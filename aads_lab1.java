public class aads_lab1 {
    public static class Node {
        String question;
        String theme;
        Node next;
    }
    public static class nodeOperations extends Node{
        Node first = null; 
        public void push(String quest, String theme){
            Node node = new Node();
            node.question = quest;
            node.next = first;
            node.theme = theme;
            first = node;
        }
        public void pop() {
            if (first != null) {
                first = first.next;
            }
        }
        public Boolean isEmpty() {
            if (first != null) return false;
            return true;
        }
        public void printList() {
            Node node = first;
            while (node != null) {
                System.out.println("Theme: " + node.theme);
                System.out.print(node.question + " => ");
                node = node.next;
            }
            System.out.println("null");
        }
    }
    

    public static void main(String[] args) {
        nodeOperations node = new nodeOperations();

    }
}