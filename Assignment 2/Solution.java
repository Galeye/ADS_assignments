import java.util.*;

public class Solution<Key extends Comparable<Key>, Value> {
    private Node root;             // root of BST
    private int size;
    private int count;
                  // number of nodes in subtree
    private class Node {
        private Key key;           // sorted by key
        private Value val;         // associated data
        private Node left, right;  // left and right subtrees
        

        public Node(Key key, Value val) {
            this.key = key;
            this.val = val;
           // left = right = null;
        }
    }

    /**
     * Initializes an empty symbol table.
     */
    public Solution() {
        root = null;
    }

    /**
     * Returns true if this symbol table is empty.
     * @return {@code true} if this symbol table is empty; {@code false} otherwise
     */
    public boolean isEmpty() {
        if(size()==0){
            return true;
        }
        return false;
    }

    /**
     * Returns the number of key-value pairs in this symbol table.
     * @return the number of key-value pairs in this symbol table
     */
    public int size() {
        if (root == null) 
            return 0; 
          
        // traversal starts from level zero. 
        Queue<Node> q = new LinkedList<Node>(); 
        q.add(root); //add() method adds the root to the queue 
        count = 1;  
        while (!q.isEmpty()) 
        { 
            Node tmp = q.remove(); //remove()method returns and removes the first key.
      
            // when the queue is empty: 
            // the remove() method returns null. 
            if (tmp != null) 
            { 
                if (tmp.left != null) 
                { 
                    // Increment count 
                    count++; 
                      
                    // Enqueue left child  
                    q.add(tmp.left); 
                } 
                if (tmp.right != null) 
                { 
                    // Increment count 
                    count++; 
                      
                    // Enqueue left child  
                    q.add(tmp.right); 
                } 
            } 
        } 
        return count;     
    }

    

//     /**
//      * Does this symbol table contain the given key?
//      *
//      * @param  key the key
//      * @return {@code true} if this symbol table contains {@code key} and
//      *         {@code false} otherwise
//      * @throws IllegalArgumentException if {@code key} is {@code null}
//      */
//     // public boolean contains(Key key) {
       
//     // }

    /**
     * Returns the value associated with the given key.
     *
     * @param  key the key
     * @return the value associated with the given key if the key is in the symbol table
     *         and {@code null} if the key is not in the symbol table
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public Value get(Key key) {
       if(key==null)throw new IllegalArgumentException("Called get() with null key"); 
       Node x = root;
       while (x!=null){
        int cmp = key.compareTo(x.key);
        if(cmp<0){
            x = x.left; 
        }
        else if(cmp>0){
            x = x.right;
        }
        else{
            System.out.println("Get = " +x.val);
            return x.val;
        }
       }
       return null;
    }

    /**
     * Inserts the specified key-value pair into the symbol table, overwriting the old 
     * value with the new value if the symbol table already contains the specified key.
     * Deletes the specified key (and its associated value) from this symbol table
     * if the specified value is {@code null}.
     *
     * @param  key the key
     * @param  val the value
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */
    public void put(Key key, Value val){
        if(key==null)throw new IllegalArgumentException("Called put() with null key");
        Node newNode = new Node(key,val);
        if(root == null){
            root = newNode; //if root is null then the root will be the newNode
        }
        else{
            Node curNode = root; //assigning current Node as root
            Node parent; 
            while(root!=null){
                parent = curNode; 
                int cmp = key.compareTo(curNode.key);
                if(cmp < 0){
                    curNode = curNode.left; //left node of the current will be assigned as curnode 
                    if(curNode == null){
                        parent.left = newNode; //if curnode is null then the new node will be
                        return;                //inserted in the left of the curnode     
                    }
                    else if(curNode.key == key){
                        curNode.val = val;  //replacing old value with the new value
                        return;             //when there are two same keys
                    }
                }
                else if(cmp > 0){
                    curNode = curNode.right;
                    if(curNode == null){
                        parent.right = newNode;
                        return;
                    }
                    else if(curNode.key == key){
                        curNode.val = val;
                        return;
                    }
                }
            }
        }
    }
    

    /**
     * Returns the smallest key in the symbol table.
     *
     * @return the smallest key in the symbol table
     * @throws NoSuchElementException if the symbol table is empty
     */ 

    public Key min() {
        if(isEmpty())throw new NoSuchElementException("Called min() with an empty symbol table"); 
        Node x = root;
        while(x.left!=null){
            x = x.left;
        }
        System.out.println("Min = "+x.key);
        return x.key;     
    }

    public Key max() {
        if(isEmpty())throw new NoSuchElementException("Called min() with an empty symbol table"); 
        Node x = root;
        while(x.right!=null){
            x = x.right;
        }
        //System.out.println("Max = "+x.key);
        return x.key;     
    } 


    /**
     * Returns the largest key in the symbol table less than or equal to {@code key}.
     *
     * @param  key the key
     * @return the largest key in the symbol table less than or equal to {@code key}
     * @throws NoSuchElementException if there is no such key
     * @throws IllegalArgumentException if {@code key} is {@code null}
     */

    public Key floor(Key key) {
        if(isEmpty())throw new NoSuchElementException("Called floor() with an empty symbol table");
        if(key == null)throw new IllegalArgumentException("Called floor() with a null key");
        Node x = root;
        if (x==null){
            return null;   
        }
        
        while(x!=null){
            int cmp = key.compareTo(x.key);
            if(cmp == 0){
                return x.key;
            }
            else if (cmp<0){
                x = x.left;
            }
            Node t = x.right;
            if(t!=null){
                return t.key;
            }
            else{
                return x.key;
            }    
        }
        return x.key;
    }

    /**
     * Return the key in the symbol table whose rank is {@code k}.
     * This is the (k+1)st smallest key in the symbol table.
     *
     * @param  k the order statistic
     * @return the key in the symbol table of rank {@code k}
     * @throws IllegalArgumentException unless {@code k} is between 0 and
     *        <em>n</em>–1
     */

    public Key select(int k) {
        if(k<0&&k>size()) throw new IllegalArgumentException("In select(), rank should be between 0-its size");   
        return select(root,k+1).key;
    }
    private Node select(Node x, int k){
        int c = 0;
        Queue<Node> queue = new LinkedList<Node>();
        Node t = root;
        while(!queue.isEmpty()||t!=null){
            if(t!=null){
                queue.add(t);
                t = t.left;
            }
            else{
                t = queue.remove();
                c++;
                if(c==k){
                    break;
                }
                t = t.right;
            }
        }
        return t;
    }

     

    

//     /**
//      * Returns all keys in the symbol table in the given range,
//      * as an {@code Iterable}.
//      *
//      * @param  lo minimum endpoint
//      * @param  hi maximum endpoint
//      * @return all keys in the symbol table between {@code lo} 
//      *         (inclusive) and {@code hi} (inclusive)
//      * @throws IllegalArgumentException if either {@code lo} or {@code hi}
//      *         is {@code null}
//      */
    public Iterable<Key> keys(Key lo, Key hi) {
        if (lo == null) throw new IllegalArgumentException ("called keys() with null low");
        if (hi == null) throw new IllegalArgumentException ("called keys() with null low");
        Node x = root; //assigning x as root
        Queue<Key> queue = new LinkedList<>();
        if(x==null)return null;
        int tmplo = lo.compareTo(x.key); //to compare lowest key with with root key
        int tmphi = hi.compareTo(x.key); //to compare highest key with with root key
        while(x!=null){
            if (tmplo < 0) {
                x = x.left;
            }
            if(tmplo <= 0 && tmphi >= 0){
                queue.add(x.key);
            }
            if(tmphi > 0){
                x = x.right;
            }

        }
        return queue;     
    } 
}