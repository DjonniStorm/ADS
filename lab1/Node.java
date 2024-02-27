public class Node {
    private String question;
    private String theme;
    private Node next;
    private Node first = null;
    public Node(String theme) {
        this.theme = theme;
    }
    public void push(String question) {
        Node node = new Node(theme);
        node.question = question;
        node.next = first;
        first = node;
    }
    public void pop() {
        if (first != null) first = first.next;
    }
    public Boolean isEmpty() {
        if (first != null) return false;
        return true;
    }
    public void printList() {
        Node node = first;
        System.out.println("Theme: " + theme);
        while (node != null) {
            System.out.print(node.question + " => ");
            node = node.next;
        }
        System.out.println("null");
        
    }
}
