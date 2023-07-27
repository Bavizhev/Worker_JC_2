public class Worker {
    private OnTaskDoneListener callback;
    private OnTaskErrorListener errorCallback;

    @FunctionalInterface
    public interface OnTaskDoneListener {
        void onDone(String result);
    }

    @FunctionalInterface
    public interface OnTaskErrorListener {
        void onError(String result);
    }

    public Worker(OnTaskDoneListener callback, OnTaskErrorListener errorCallback) {
        this.callback = callback;
        this.errorCallback = errorCallback;
    }

    public void onError() {
        for (int i = 0; i < 100; i++) {
            if (i % 3 == 0 && i != 0) {
                errorCallback.onError("Task " + i + " is error");
            } else {
                callback.onDone("Task " + i + " is done");
            }
        }
    }
}