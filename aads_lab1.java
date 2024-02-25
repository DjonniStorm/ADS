public class aads_lab1 {
    public static class Node {
        String question;
        Node next;
    }
    public static class nodeOperations extends Node {
        Node first = null;
        public void push(String quest){
            Node node = new Node();
            node.question = quest;
            node.next = first;
            first = node;
        }
        public void pop(){
            if (first != null){
                first = first.next;
            }
        }
        public void printList(){
            Node node = first;
            while (node != null) {
                System.out.println(node.question);
                node = node.next;
            }
            System.out.println("null");
        }
    }
    

    public static void main(String[] args) {
        String z1 = "list1";
        String z2 = "list2";
        String z3 = "list3";
        String z4 = "list4";
        nodeOperations node = new nodeOperations();
        node.printList();
        node.pop();
        node.printList();
    }
}