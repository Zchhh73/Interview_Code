package yuan_code;


import java.util.LinkedList;
import java.util.Queue;

/**
 *  6.二叉树宽度
 */
public class Question006 {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int data){
            this.val = data;
        }
    }

    public class Node{
        TreeNode node;
        int pos,depth;
        Node(TreeNode no,int dep,int p){
            this.node = no;
            this.depth = dep;
            this.pos = p;
        }
    }
    public int widthOfBinaryTree(TreeNode root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(root,0,0));
        int curDepth = 0;
        int res = 0;
        int left = 0;
        while(!queue.isEmpty()){
            Node temp = queue.poll();
            if(temp.node != null){
                queue.add(new Node(temp.node.left,temp.depth+1,temp.pos*2));
                queue.add(new Node(temp.node.right,temp.depth+1,temp.pos*2+1));
                if(curDepth != temp.depth){
                    curDepth = temp.depth;
                    left = temp.pos;
                }
                res = Math.max(res,temp.pos-left+1);
            }
        }
        return res;
    }
}
