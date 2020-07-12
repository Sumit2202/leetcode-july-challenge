class Solution {

    //Definition for a binary tree node.
    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) { this.val = val; }
        TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
     }
  }

    //Approach 1 
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();

        if(root==null)
        return result;

        Queue<TreeNode> q = new LinkedList<TreeNode>();

        q.add(root);

        int count;
        while(!q.isEmpty()){
            List<Integer> res  = new ArrayList<Integer>();
            count = q.size();

            while(count!=0){
                TreeNode temp = q.poll();
                res.add(temp.val);
                if(temp.left!=null){
                    q.add(temp.left);
                }
                if(temp.right!=null){
                    q.add(temp.right);
                }
                count--;
            }
            result.add(0,res);
        }
        return result;
    }

    //Approach 2
    List<List<Integer>> result ;
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        result = new ArrayList();
        
        if(root == null){
            return result;
        }

        List<Integer> res = new ArrayList();
        res.add(root.val);
        result.add(res);

        bfs(root, 1);

        Collections.reverse(result);
        return result;
    }

    public void bfs(TreeNode root, int level){
        List<Integer> res = new ArrayList();
        if(root == null){
            return;
        }
        if( (root.left!=null || root.right!=null) && result.size()<=level ){
            result.add(res);
        }
        if(root.left!=null){
            result.get(level).add(root.left.val);
        }
        if(root.right!=null){
            result.get(level).add(root.right.val);
        }
        bfs(root.left,level+1);
        bfs(root.right,level+1);
    }
