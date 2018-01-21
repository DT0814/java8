package pack;

import java.util.*;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class LambdaDemo extends Thread {
    @org.junit.Test
    public void fun() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");

        System.out.println("Languages which starts with J :");
        filter(languages, (str) -> str.startsWith("J"));
        System.out.println("Languages which ends with a ");
        filter(languages, (str) -> str.endsWith("a"));

        System.out.println("Print all languages :");
        filter(languages, (str) -> true);

        System.out.println("Print no language : ");
        filter(languages, (str) -> false);

        System.out.println("Print language whose length greater than 4:");
        filter(languages, (str) -> str.length() > 4);
    }


    public static void filter(List names, Predicate<String> condition) {
        /*for (Object name : names) {
            if (condition.test((String) name)) {
                System.out.println(name + " ");
            }
        }*/
        names.stream().filter((name) -> (condition.test((String) name))).forEach((name) -> {
            System.out.println(name + " ");
        });
    }

    @org.junit.Test
    public void fun1() {
        List<String> languages = Arrays.asList("Java", "Scala", "C++", "Haskell", "Lisp");
        Predicate<String> strtJ = (n) -> n.startsWith("J");
        Predicate<String> len4 = (n) -> n.length() == 4;
        languages.stream()
                .filter(strtJ.and(len4))
                .forEach((n) -> System.out.print(n));
    }

    @org.junit.Test
    public void fun2() {
        List<Integer> beforeNumber = Arrays.asList(100, 200, 300, 400);
        beforeNumber.stream().map((num) -> num + .2 * num).forEach(System.out::println);
        Double aDouble = beforeNumber.stream().map((num) -> num + .2 * num).reduce((sum, num) -> sum += num).get();
        System.out.println(aDouble);
    }

    @org.junit.Test
    public void fun3() {
        List<String> list = Arrays.asList("USA", "Japan", "France", "Germany", "Italy", "U.K.", "Canada");
        list.stream().map(x -> x.toUpperCase()).forEach((string) -> System.out.println(string));
        String G7Countries = list.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.println(G7Countries);
    }

    @org.junit.Test
    public void fun4() {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map(i -> i *= i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s \n", numbers, distinct);
    }

    @org.junit.Test
    public void fun5() {
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        //intSummaryStatistics,DoubleSummaryStatistics,LongSummaryStatistics等
        IntSummaryStatistics intSummaryStatistics = primes.stream().mapToInt(x -> x).summaryStatistics();
        System.out.println(intSummaryStatistics.getAverage());
        System.out.println(intSummaryStatistics.getMax());
        System.out.println(intSummaryStatistics.getCount());
        System.out.println(intSummaryStatistics.getMin());
        System.out.println(intSummaryStatistics.getSum());
    }

    @org.junit.Test
    public void fun6() {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println(this);
            }
        });
        thread.start();
        Thread thread1 = new Thread(() -> {
            System.out.println(this);
        });
        thread1.start();
    }

    @org.junit.Test
    public void fun7() {
        List<Test> list = new ArrayList<Test>();
        Test test = new Test(1, "dongtao");
        Test test1 = new Test(2, "zjy");
        Test test2 = new Test(3, "hd");
        list.add(test2);
        list.add(test);
        list.add(test1);
        Iterator<Test> iterator = list.iterator();
        while (iterator.hasNext()) {
            Test next = iterator.next();
            System.out.println(next.getName() + " :" + next.getNun());
        }
        Collections.sort(list, (a, b) -> {
            return a.getNun().compareTo(b.getNun());
        });
        list.forEach(n -> {
            System.out.println(n);
            System.out.println(n.getNun());
        });
        list.forEach(System.out::println);
    }

    @org.junit.Test
    public void fun8() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    while (true) {
                        //Thread.sleep(1000);
                        LambdaDemo.sleep(1000);
                        System.out.println(new Date().getTime());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(() -> {
            while (true) {
                try {
                    LambdaDemo.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(new Date().getTime());
            }

        }).start();
        /*IntBinaryOperator intBinaryOperator = (int even, int odd) -> even + odd;
    new Thread(() -> System.out.println(intBinaryOperator.applyAsInt(1, 2))).start();*/
    }
}
