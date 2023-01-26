import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Predicate<Integer> predicate = new Predicate<>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        System.out.println(predicate.test(-15));

        Predicate<Integer> isPositive = x -> x > 0;
        System.out.println(isPositive.test(5));
        System.out.println(isPositive.test(-7));

        System.out.println("-------------------------------------");

        Consumer<String> consumer = new Consumer<>() {
            @Override
            public void accept(String s) {
                System.out.println("Greetings " + s);
            }
        };
        consumer.accept("Nicolay");

        Consumer<String> greetings = x -> System.out.println("Greetings " + x);
        greetings.accept("Mikola");

        System.out.println("-------------------------------------");

        Function<Double, Long> function = new Function<>() {
            @Override
            public Long apply(Double aDouble) {
                return aDouble.longValue();
            }
        };
        System.out.println(function.apply(958462.999));

        Function<Double, Long> doubleLongFunction = Double::longValue;
        System.out.println(doubleLongFunction.apply(6584.69));

        System.out.println("-------------------------------------");

        Supplier<Integer> supplier = new Supplier<>() {
            @Override
            public Integer get() {
                return (int) (Math.random() * 100);
            }
        };
        System.out.println(supplier.get());

        Supplier<Integer> random = () -> (int) (Math.random() * 100);
        System.out.println(random.get());

        System.out.println("-------------------------------------");

        Predicate<Object> condition = Objects::isNull;
        Function<Object, String> ifTrue = obj -> "null";
        Function<Object, String> ifFalse = Object::toString;
        Function<Object, String> objectToCharSequence =
                ternaryOperator(condition, ifTrue, ifFalse);

    }
    public static <T, U> Function<T, U> ternaryOperator(Predicate<? super T> condition,
                                                Function<? super T, ? extends U> ifTrue,
                                                Function<? super T, ? extends U> ifFalse) {
        return t -> condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
    }
}