import java.util.*;

/**
 * Класс для тестирования производительности ArrayList и LinkedList.
 * Сравнивает время выполнения основных операций коллекций.
 */
public class PerformanceTest
{
    private static final int ITERATIONS = 5000;

    /**
     * Главный метод программы.
     * Запускает тесты для ArrayList и LinkedList, выводит результаты.
     *
     * @param args аргументы командной строки
     */
    public static void main(String[] args)
    {
        System.out.println("--- ТЕСТ ПРОИЗВОДИТЕЛЬНОСТИ ArrayList vs LinkedList ---");
        System.out.println("Количество операций: " + ITERATIONS + "\n");

        List<TestResult> results = new ArrayList<>();

        results.addAll(testArrayList());
        results.addAll(testLinkedList());

        printResultsTable(results);
    }

    /**
     * Тестирует производительность основных методов ArrayList.
     *
     * @return список результатов тестирования ArrayList
     */
    private static List<TestResult> testArrayList()
    {
        List<TestResult> results = new ArrayList<>();
        List<Integer> list = new ArrayList<>();

        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++)
            list.add(i);

        long endTime = System.nanoTime();
        results.add(new TestResult("ArrayList", "add (в конец)", ITERATIONS, endTime - startTime));

        list.clear();
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++)
            list.add(0, i);

        endTime = System.nanoTime();
        results.add(new TestResult("ArrayList", "add (в начало)", ITERATIONS, endTime - startTime));

        list.clear();
        for (int i = 0; i < ITERATIONS; i++)
            list.add(i);

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++)
            list.get(i);

        endTime = System.nanoTime();
        results.add(new TestResult("ArrayList", "get (по индексу)", ITERATIONS, endTime - startTime));

        list.clear();
        for (int i = 0; i < ITERATIONS; i++)
            list.add(i);

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++)
            list.indexOf(i);

        endTime = System.nanoTime();
        results.add(new TestResult("ArrayList", "indexOf", ITERATIONS, endTime - startTime));

        list.clear();
        for (int i = 0; i < ITERATIONS; i++)
            list.add(i);

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++)
            list.contains(i);

        endTime = System.nanoTime();
        results.add(new TestResult("ArrayList", "contains", ITERATIONS, endTime - startTime));

        list.clear();
        for (int i = 0; i < ITERATIONS; i++)
            list.add(i);

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS / 2; i++)
            list.remove(0);

        endTime = System.nanoTime();
        results.add(new TestResult("ArrayList", "remove (с начала)", ITERATIONS / 2, endTime - startTime));

        list.clear();
        for (int i = 0; i < ITERATIONS; i++)
            list.add(i);

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS / 2; i++)
            list.remove(list.size() - 1);

        endTime = System.nanoTime();
        results.add(new TestResult("ArrayList", "remove (с конца)", ITERATIONS / 2, endTime - startTime));

        return results;
    }

    /**
     * Тестирует производительность основных методов LinkedList.
     *
     * @return список результатов тестирования LinkedList
     */
    private static List<TestResult> testLinkedList()
    {
        List<TestResult> results = new ArrayList<>();
        LinkedList<Integer> list = new LinkedList<>();

        long startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++)
            list.add(i);

        long endTime = System.nanoTime();
        results.add(new TestResult("LinkedList", "add (в конец)", ITERATIONS, endTime - startTime));

        list.clear();
        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++)
            list.add(0, i);

        endTime = System.nanoTime();
        results.add(new TestResult("LinkedList", "add (в начало)", ITERATIONS, endTime - startTime));

        list.clear();
        for (int i = 0; i < ITERATIONS; i++)
            list.add(i);

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++)
            list.get(i);

        endTime = System.nanoTime();
        results.add(new TestResult("LinkedList", "get (по индексу)", ITERATIONS, endTime - startTime));

        list.clear();
        for (int i = 0; i < ITERATIONS; i++)
            list.add(i);

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++)
            list.indexOf(i);

        endTime = System.nanoTime();
        results.add(new TestResult("LinkedList", "indexOf", ITERATIONS, endTime - startTime));

        list.clear();
        for (int i = 0; i < ITERATIONS; i++)
            list.add(i);

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS; i++)
            list.contains(i);

        endTime = System.nanoTime();
        results.add(new TestResult("LinkedList", "contains", ITERATIONS, endTime - startTime));

        list.clear();
        for (int i = 0; i < ITERATIONS; i++)
            list.add(i);

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS / 2; i++)
            list.remove(0);

        endTime = System.nanoTime();
        results.add(new TestResult("LinkedList", "remove (с начала)", ITERATIONS / 2, endTime - startTime));

        list.clear();
        for (int i = 0; i < ITERATIONS; i++)
            list.add(i);

        startTime = System.nanoTime();
        for (int i = 0; i < ITERATIONS / 2; i++)
            list.remove(list.size() - 1);

        endTime = System.nanoTime();
        results.add(new TestResult("LinkedList", "remove (с конца)", ITERATIONS / 2, endTime - startTime));

        return results;
    }

    /**
     * Выводит таблицу с результатами тестирования в консоль.
     *
     * @param results список результатов тестирования
     */
    private static void printResultsTable(List<TestResult> results)
    {
        System.out.println("\n--- РЕЗУЛЬТАТЫ ТЕСТИРОВАНИЯ ---\n");
        System.out.printf("%-20s %-25s %-15s %-15s%n", "Коллекция", "Метод", "Вызовов", "Время (мс)");
        System.out.println("-----------------------------------------------------------------------------");

        for (TestResult result : results)
        {
            double timeMs = result.timeNanos / 1_000_000.0;
            System.out.printf("%-20s %-25s %-15d %-15.3f%n",
                    result.collectionType,
                    result.method,
                    result.operationCount,
                    timeMs);
        }

        System.out.println("-----------------------------------------------------------------------------");

        System.out.println("\n--- АНАЛИЗ ПРОИЗВОДИТЕЛЬНОСТИ ---\n");
        analyzeResults(results);
    }

    /**
     * Анализирует результаты и выводит сравнение производительности.
     * Вычисляет, какая коллекция быстрее для каждого метода.
     *
     * @param results список результатов тестирования
     */
    private static void analyzeResults(List<TestResult> results)
    {
        Map<String, TestResult> arrayListResults = new HashMap<>();
        Map<String, TestResult> linkedListResults = new HashMap<>();

        for (TestResult result : results)
        {
            if (result.collectionType.equals("ArrayList"))
                arrayListResults.put(result.method, result);

            else
                linkedListResults.put(result.method, result);

        }

        for (String method : arrayListResults.keySet())
        {
            TestResult arrayResult = arrayListResults.get(method);
            TestResult linkedResult = linkedListResults.get(method);

            double ratio = (double) arrayResult.timeNanos / linkedResult.timeNanos;
            String faster = ratio > 1 ? "LinkedList" : "ArrayList";
            double times = ratio > 1 ? ratio : 1 / ratio;

            System.out.printf("%s: %s быстрее в %.2f раз%n", method, faster, times);
        }
    }
}

