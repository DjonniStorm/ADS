import java.util.ArrayList;
import java.util.Collections;
import java.util.TreeMap;

public class Task1 {
    public static void main(String[] args) {
        
        String text = "where there's a will there's a way";

        // вычисляем частоты символов в тексте
        TreeMap<Character, Integer> frequencies = countFrequency(text);

        // генерируем список листов дерева
        ArrayList<Node> codeTreeNodes = new ArrayList<>();
        for(Character c: frequencies.keySet()) {
            codeTreeNodes.add(new Node(c, frequencies.get(c)));
        }

        // строим кодовое дерево с помощью алгоритма Хаффмана
        Node tree = huffman(codeTreeNodes);

        // генерируем таблицу префиксных кодов для кодируемых символов с помощью кодового дерева
        TreeMap<Character, String> codes = new TreeMap<>();
        for(Character c: frequencies.keySet()) {
            codes.put(c, tree.getCodeForCharacter(c, ""));
        }

        System.out.println("Таблица префиксных кодов: " + codes.toString());
    }

    private static TreeMap<Character, Integer> countFrequency(String str) {
        TreeMap<Character, Integer> freqMap = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            Character symbol = str.charAt(i);
            Integer counter = freqMap.get(symbol);
            if (counter == null) freqMap.put(symbol, 1);
            else freqMap.put(symbol, counter + 1);
        }
        return freqMap;
    }

    private static Node huffman(ArrayList<Node> nodes) {
        while (nodes.size() > 1) {
            Collections.sort(nodes);
            Node left = nodes.remove(nodes.size() - 1);
            Node right = nodes.remove(nodes.size() - 1);

            Node together = new Node(null, right.frequency + left.frequency, left, right);
            nodes.add(together);
        }
        return  nodes.get(0);
    }
    // класс для представления кодового дерева
    private static class Node implements Comparable<Node> {

        Character symbol;
        int frequency;
        Node left;
        Node right;

        public Node(Character symbol, int frequency) {
            this.symbol = symbol;
            this.frequency = frequency;
        }

        public Node(Character symbol, int frequency, Node left, Node right) {
            this.symbol = symbol;
            this.frequency = frequency;
            this.left = left;
            this.right = right;
        }

        @Override
        public int compareTo(Node o) {
            return o.frequency - frequency;
        }

        // извлечение кода для символа
        public String getCodeForCharacter(Character sym, String parent) {
            if (symbol == sym) {
                return  parent;
            } else {
                if (left != null) {
                    String path = left.getCodeForCharacter(sym, parent + 0);
                    if (path != null) {
                        return path;
                    }
                }
                if (right != null) {
                    String path = right.getCodeForCharacter(sym, parent + 1);
                    if (path != null) {
                        return path;
                    }
                }
            }
            return null;
        }
    }
}