private ArrayList<Integer> heapArray;
public class task1 {
    public task1() {
        heapArray = new ArrayList<>();
    }
    private int HeapSize() {
        return heapArray.size();
    }
    public boolean isEmpty() {
        return heapArray.isEmpty();
    }
    public void push(int elem) {
        heapArray.add(elem);
        siftUp(heapArray.indexOf(elem));
        heapify();
    }
    private void siftUp(int index) {
        while (index >= 0) {
            if (heapArray.get(index) < heapArray.get((index - 1) / 2)) {
                swap(index, (index - 1) / 2);
                index = (index - 1) / 2;
            } else break;
        }
//        while (index > 0) {
//            if (index % 2 == 1) {
//                int src = (index - 1) / 2;
//                if (heapArray.get(index) < heapArray.get(src)) {
//                    swap(index, src);
//                }
//                index = (index - 1) / 2;
//            }
//            if (index % 2 == 0) {
//                if (heapArray.get(index) < heapArray.get(index / 2)) {
//                    swap(index, index / 2);
//                }
//                index /= 2;
//            }
//            if (index == 1) {
//                break;
//            }
    }
    private void heapify() {
        for (int i = HeapSize() - 1; i >= 0; --i) {
            siftUp(i);
        }
    }
    private void siftDown(int index) {
        while (2 * index + 1 < HeapSize()) {
            int i = index * 2 + 1;
            if ((index * 2 + 2) < HeapSize()) {
                if (heapArray.get(index * 2 + 1) > heapArray.get(index * 2 + 2)) {
                    i = index * 2 + 2;
                }
            }
            if (heapArray.get(index) > heapArray.get(i)) {
                swap(index, i);
                index = i;
            }
            else break;
        }
    }
    public Integer getMin() {
        if (isEmpty()) return null;
        int min = heapArray.getFirst();
        heapArray.set(0, heapArray.getLast());
        heapArray.removeLast();
        siftDown(0);
        heapify();
        return min;
    }
    private void swap(int index1, int index2) {
        int tempVariable = heapArray.get(index1);
        heapArray.set(index1, heapArray.get(index2));
        heapArray.set(index2, tempVariable);
    }
    public void printHeapArray() {
        System.out.print("\n");
        for (int i : heapArray) {
            System.out.printf("%5d  ", i);
        }
        System.out.print("\n");
    }
    public void beautifullPrint() {
        for (int i = 0; i < heapArray.size(); i++) {
            int leftChild = 2 * i + 1;
            int rightChild = 2 * i + 2;

            if (leftChild < heapArray.size()) {
                System.out.print(heapArray.get(i) + " -- " + heapArray.get(leftChild) + ";\n");
            }

            if (rightChild < heapArray.size()) {
                System.out.print(heapArray.get(i) + " -- " + heapArray.get(rightChild) + ";\n");
            }
        }
    }

}

