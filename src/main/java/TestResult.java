/**
 * Класс для хранения результатов тестирования производительности.
 * Содержит информацию о типе коллекции, методе, количестве операций и времени выполнения.
 */
public class TestResult
{
    String collectionType;
    String method;
    int operationCount;
    long timeNanos;

    /**
     * Конструктор для создания результата тестирования.
     *
     * @param collectionType тип коллекции (ArrayList или LinkedList)
     * @param method название тестируемого метода
     * @param operationCount количество выполненных операций
     * @param timeNanos время выполнения в наносекундах
     */
    public TestResult(String collectionType, String method, int operationCount, long timeNanos)
    {
        this.collectionType = collectionType;
        this.method = method;
        this.operationCount = operationCount;
        this.timeNanos = timeNanos;
    }
}


