import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;


public class vertical_traversal {
    public static void vTraversal(Node root){
        Queue<Pair> q = new LinkedList<Pair>();
        Map<Integer,ArrayList<Integer>> mp = new TreeMap<>();
        q.add(new Pair(root, 0));
        while(q.isEmpty()==false){
            Pair p =q.poll();
            Node curr = p.node;
            int hd = p.hd;
            if(mp.containsKey(hd))
                mp.get(hd).add(curr.key);
            else{
                ArrayList<Integer> a1 = new ArrayList<>();
                a1.add(curr.key);
                mp.put(hd, a1);
            }
            if(curr.left!=null)
                q.add(new Pair(curr.left, hd-1));
            if(curr.right!=null)
                q.add(new Pair(curr.right, hd+1));
            
        }
        for(Map.Entry<Integer,ArrayList<Integer>>p : mp.entrySet())
        {
            ArrayList<Integer> a1 = p.getValue();
            for(int n: a1){
                System.out.println(n + "");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        Node root = new Node(10);
        root.left = new Node(20);
        root.right = new Node(30);
        root.left.left = new Node(40);
        root.left.right = new Node(50);
        vTraversal(root);
    }
}

class Node{
    int key;
    Node left , right;
    Node(int x){
        key = x;
        left = right = null;
    }
}

class Pair {
    Node node;
    int hd;
    Pair(Node n ,int h){
        node=n;
        hd=h;
    }
}