public class TestResult
{
    String collectionType;
    String method;
    int operationCount;
    long timeNanos;

    public TestResult(String collectionType, String method, int operationCount, long timeNanos)
    {
        this.collectionType = collectionType;
        this.method = method;
        this.operationCount = operationCount;
        this.timeNanos = timeNanos;
    }
}

