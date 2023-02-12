
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        checkWordsStatistic("I ate a lot of apples");
        checkWordsStatistic("Съешь еще этих мягких французских булок и выпей чаю и конфету съешь");

    }
    public static void checkWordsStatistic(String str) {
        String str1 = str.toLowerCase();
        String[] words = str1.split(" ");
        int quantity = words.length;
        System.out.println("В тексте " + quantity + " слов");
        List<String> list = List.of(words);
        list.stream()
                .flatMap(line -> Stream.of(line.split("\\s+")))
                .map(word -> word.replaceAll("[^A-Za-zА-Яа-яЁё]+", "").toLowerCase())
                .collect(Collectors.toMap(key -> key, val -> 1, Integer::sum))
                .entrySet().stream()
                .sorted((e1, e2) -> {
                    int val = e1.getValue().compareTo(e2.getValue()) * -1;
                    if (val == 0) {
                        val = e1.getKey().compareTo(e2.getKey());
                        if (e1.getKey().charAt(0) <= 'z'
                                && e2.getKey().charAt(0) > 'z'
                                || e1.getKey().charAt(0) > 'z'
                                && e2.getKey().charAt(0) <= 'z') {
                            val *= -1;
                        }
                    }
                    return val;
                })
                .forEach(e -> System.out.println(e.getValue() + " = " + e.getKey()));
    }
}