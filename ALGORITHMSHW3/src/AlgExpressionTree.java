//-----------------------------------------------------
// Title: Expression Tree
// Author: Hilalnur Beral
// ID: 11549136358
// Section: 01
// Assignment: 3
// Description: This class defines a expression tree and its methods.Alll required methods and test cases are in this class.
//-----------------------------------------------------




import java.util.ArrayList; // Importing of ArrayList



import java.util.LinkedList; //Importing of Linkedlist

import java.util.List;     // Importing of List

import java.util.NoSuchElementException;

import java.util.Queue;    // Importing of Queue

import java.util.Stack;    // Importing of Stack


// I used arraylist,linkedlist,list,stack and queue for implementation of this class.

class Node {
      
      
      Node nodeRoot;
      
      char valueD;
      
      Node left, right;
      
      int depthH=0; // depth variable
      
    int levelS=0;   // level variable
    
    int drawTree=0;
    
    char varName;  // varName declaration;
    int varValue;   //varValue declaration ;

      Node(char item) {
            valueD = item;
            left = right = null;
      }
}

public class AlgExpressionTree {

	
	
	
      boolean isOperator(char ch) {
    	  
    	  //--------------------------------------------------------
          // Summary: This boolean method control whether given char value is an operator or not
          // Precondition:ch is a char
          // Postcondition: Control is done succesfully and it returns boolean value.
          //-------------------------------------------------------
          // now body of the method...
          
    	  
            if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
                  return true;
            }
            return false;
      }

      static Node root;
      String expression;

      public AlgExpressionTree(String expression) {
            this.expression = expression;
            this.root = this.constructExpressionTree(expression);
      }

      private Node constructExpressionTree(String expression) {
            
            //--------------------------------------------------------
            // Summary: This method parses given expression and then it constructs an expression tree.
            // Precondition:Expression is a string
            // Postcondition: Expression tree is constructed succesfully.
            //-------------------------------------------------------
            // now body of the method...
            
            this.expression=expression;
            // Turning expression into a char array.
            
            char[] characters = expression.toCharArray(); // I parsed expression characters and put them into array.
            Stack<Node> st = new Stack(); 
           Node t, t1, t2; 
  
        // I taverse the every character of the expression
        for (int i = characters.length-1; i>=0 ; i--) { 
            
            // If operand, then I  pushed it into stack 
            if (!isOperator(characters[i])) { 
                t = new Node(characters[i]); 
                st.push(t); 
            } else // operator 
            { 
                t = new Node(characters[i]); 
  
                
                t1 = st.pop();      // I popped the node from top.
                t2 = st.pop();      // I popped the node fromo top
  
                
                t.left = t1;  // I created left child
                t.right = t2;  // I created right child
  
                
                st.push(t); // I added the subexpression to the stack.
            } 
        } 
  
        
        t = st.peek(); 
        st.pop(); 
  
        return t;
        
      }
      AlgExpressionTree T1 ;
      
      private char varName;
      
      
      private int varValue;   
      

      
      private static int maximumLevel(Node node) {
            
            // Treenin maximum levelinýný buluyor.
            if (node == null) {
               return 0;
            }
            return Math.max(maximumLevel(node.left), maximumLevel(node.right)) + 1;
         }
      
      private static void whiteBoslukPrint(int count) {
            //treeye göre whitespacleri yazdýrmak için
            for (int i = 0; i < count; i++)
               System.out.print(" ");
         }
      
      private static boolean areElementsNull(List<Node> list) {
            //--------------------------------------------------------
            // Summary:  Control whether nodes are null or not 
             // Precondition: Takes parameter type of list.
            // Postcondition: Control is done appropriately.
            //-------------------------------------------------------
            // now body of the method...
            for (Node objectNode : list) {
               if (objectNode != null)
                  return false;
            }
            return true;
         }
      
      private static void nonLeafNodePrint(List<Node> nodes, int level, int maxLevel) {
            
            //--------------------------------------------------------
            // Summary:This method is the actual method which is used for printing nodes and it is used inside the function printNode(Node root)
            // Precondition: nodes parameter is type of list, level is integer and maxlevel is integer.
            // Postcondition: Internal nodes are printed appropriately.
            //-------------------------------------------------------
            // now body of the method...
            
            if (nodes.isEmpty() || areElementsNull(nodes)) {
               return;
            }
            int floorTree = maxLevel - level;
            
            int edgeLinesTree = (int) Math.pow(1, (Math.max(floorTree - 1, 0))); // This line calculates the edgeLines numbers.
            
            int firstSpacesTree = (int) Math.pow(2, (floorTree)) - 1; 
            
            int betweenSpacesTree = (int) Math.pow(2, (floorTree + 1)) - 1;
         
            whiteBoslukPrint(firstSpacesTree);
         
            List<Node> YeniNodes = new ArrayList<Node>();
            
            
            for (Node nodeTree : nodes) {
               if (nodeTree != null) {
                  System.out.print(nodeTree.valueD); //hangi deðere geldiyse onu bastýrýyor.
                  YeniNodes.add(nodeTree.left); //ekleme yapýyor.
                  YeniNodes.add(nodeTree.right); //ekleme yapýyor.
               } else {
                  
                  YeniNodes.add(null);   // Eðer deðer yoksa null ekliyor .
                  
                  YeniNodes.add(null);    // Eðer deðer yoksa null ekliyor ve boþluk bastýrýyor.
                  
                  System.out.print(" ");  //Boþluk bastýrýyor.
               }
         
               whiteBoslukPrint(betweenSpacesTree); //Arrange the whitespaces between nodes.
            }
            System.out.println(""); // Yeni line'a geçmemizi saðlýyor.
         
            for (int hilal = 1; hilal <= edgeLinesTree; hilal++) { // It traverses according to edge lines.
              
               for (int j = 0; j < nodes.size(); j++) {
                  whiteBoslukPrint(firstSpacesTree - hilal);
                  // Prints the first Whitespace
                  if (nodes.get(j) == null) {
                     whiteBoslukPrint(edgeLinesTree + edgeLinesTree + hilal + 1);
                     continue;
                  }
         
                  if (nodes.get(j).left != null) //Nodeun lefti null deðilse left için bir tane çizgi bastýrýyor.
                        
                        
                     System.out.print("/");
                  else
                     whiteBoslukPrint(1);
         
                  whiteBoslukPrint(hilal + hilal - 1);
         
                  if (nodes.get(j).right != null)  //Nodeun righti null deðilse left için bir tane çizgi bastýrýyor.
                     System.out.print("\\");
                  else
                     whiteBoslukPrint(1);
         
                  whiteBoslukPrint(edgeLinesTree + edgeLinesTree - hilal);
               }
         
               System.out.println(""); //Baþka line'a geçiyor.
            }
         
            nonLeafNodePrint(YeniNodes, level + 1, maxLevel); // // Leveli bir arttýrýyoruz, yeni node alýyoruz.
         }
      
      private static void bastýrNode(Node root) {
            //--------------------------------------------------------
            // Summary: This method calculates maximum level of root (by calling maxLevel() function and add roots to the list.Then it calls  NonLeafNodePrint function. 
             // Precondition: root is type of Node
            // integer
            // Postcondition: It traverses the tree from level 1 to the max level for printing properly..
            //-------------------------------------------------------
            // now body of the method...
            int maxLevel = maximumLevel(root);
            
            List<Node> rootList = new ArrayList<Node>();
            
            rootList.add(root);
            
            nonLeafNodePrint(rootList, 1, maxLevel); //1.leveldan max level'a kadar ilerliyoruz.rootList nodelar ý tutuyor.
         }
      public void displayTree()
         {
            //--------------------------------------------------------
            // Summary: This method calls the printNode(Node root)method to display the tree.
            // Precondition: No parameter is included.
            // Postcondition: Tree is displayed properly..
            //-------------------------------------------------------
            // now body of the method...
            bastýrNode(root);
         }
      

      public double hesaplaExpressiontree(char cr, double leftT, double rightT) {
            
            //--------------------------------------------------------
            // Summary:  This method evaluates the expression tree according to operations (+,-,*,/)  
            // Precondition: c is a char,left is double and right is double.
            // Postcondition: Expression Tree evaluated properly.
            //-------------------------------------------------------
            // now body of the method...

        double sonuc = 0;
        switch (cr) {
        case '+':
        	// It summs the nodes
            sonuc = leftT + rightT;
            break;
        case '-':
        	// It subtracts right child from left child.
            sonuc = leftT - rightT;
            break;
        case '*':
        	// It multiplies right child with left child.
            sonuc = leftT * rightT;
            break;
        case '/':
        	// It divides left child to the right child.
            sonuc = leftT / rightT;
            break;
        }
        return sonuc;

    }
      double evaluate() {
            //--------------------------------------------------------
            // Summary: This function returns evaluateH function .
            // Precondition: No parameter included and it must have return value.
            // Postcondition: it return the evaluated result correctly.
            //-------------------------------------------------------
            // now body of the method...
      
            return evaluateH(T1.root);
      }
      
      
      double evaluateH(Node tNode){
            
            //--------------------------------------------------------
            // Summary: This method evaluates the expression tree by calling HesaplaExpressionTree method.
            // Precondition: it takes Node type parameter. 
             // Postcondition: Expression tree is evaluated correctly..
            //-------------------------------------------------------
            // now body of the method...
    	  
    	  // Also in this method  I set default value to the nodes as 0.
    	  // For example if we don't set any value to 'x' with setVariable method, its default value will be zero.
            
            int def = 0;
            
             if(root == null)
                  return 0;
            
             if(tNode.left == null && tNode.right == null) {
                  if(!Character.isDigit(tNode.valueD)) {
                  int a=tNode.valueD;
                          a =(char)(def+'0');   
                          return Character.getNumericValue(a);
                  }
                  return Character.getNumericValue(tNode.valueD);
            }
            char c = tNode.valueD;
            double leftValue = evaluateH(tNode.left);
            double rightValue = evaluateH(tNode.right);
            return hesaplaExpressiontree(c,leftValue,rightValue);
      }


      
      void displayPostfix() {
            
            //--------------------------------------------------------
            // Summary:  This method shows the postfix version of the expression.
            // Precondition: No parameter
            // Postcondition: Postfix expression is displayed
            //-------------------------------------------------------
            // now body of the method...
    T1= new AlgExpressionTree(expression);
    
        displayPostfixHelper(T1.root);         
      }
      
      void displayPostfixHelper(Node node) {
            
            //--------------------------------------------------------
            // Summary: This method is create in order to use it in displayPostfix function and it places nodes according to the postfix expression format.
            // Precondition: It takes type of Node parameter
            // Postcondition: Nodes are placed properly(for postfix expression).
            //-------------------------------------------------------
            // now body of the method...
            if (node == null) 
                  return; 
        
              // firstly, recur on left subtree 
              displayPostfixHelper(node.left); 
        
              // secondly, recur on right subtree 
              displayPostfixHelper(node.right); 
        
              // deal with the node now
              System.out.print(node.valueD); 
              
      }
      
      Node searchFindNode(Node rootTree, char valueTree) {
            //--------------------------------------------------------
            // Summary: This method finds the wanted node whether its value is in expression or not.
            // Precondition: root is type of node and val is char
            // Postcondition: Wanted node is found.
            //-------------------------------------------------------
            // now body of the method...
          if (rootTree == null) return null; // no such node
          if (valueTree == rootTree.valueD) return rootTree; // the node itself contains the value
          
          Node n = searchFindNode(rootTree.left, valueTree); // search left sub-tree
          if (n != null) return n; // we've found it in the left sub-tree

          return searchFindNode(rootTree.right, valueTree); // search right sub-tree
      }

      
      
      void setVariable(char varName, int varValue) {
    	
    	  //--------------------------------------------------------
    	  // Summary: Assigns a value to the variable whose name is given.
    	  // Precondition: varName is a char and varValue is an integer
    	  // Postcondition: The value of the variable is set.
    	  
    	  //Body of the method
    	  
            
            T1= new AlgExpressionTree(expression);
            
            Node bulunanNode = searchFindNode(T1.root, varName);
            
            // System.out.println(n.value);
            
             char chb =(char)(varValue + '0');
            bulunanNode.valueD=chb;
            // System.out.println(n.value);
      }

      
      
     
      
      public static void main(String[] args) {   // This main method is created for testing my methods.
            
   
            //--------------------------------------------------------
            // Summary: This main method test our methods and expression tree..
            // Precondition: Functions should be implemented properly
            // Postcondition: All functions are tested with test cases properly..
            //-------------------------------------------------------
            // now body of the method...
            
            
            AlgExpressionTree T1 = new AlgExpressionTree("+*3x5");
            
            T1.displayTree();
            // Evaluate the expression for x = 0 (default value):
            //T1.setVariable('x',0);
            System.out.println("Result for x = 0 : " + T1.evaluate());
            // Evaluate the expression for x = 8, but do not change the tree:
            T1.displayTree();
            T1.setVariable('x', 8);
            System.out.println("Tree when x=8");
            System.out.println();
            T1.displayTree();
            System.out.println();
            System.out.println("Result for x = 8 : " + T1.evaluate());
            // Evaluate the expression for x = 6, but do not change the tree:
            T1.setVariable('x', 6);
            System.out.println("Tree when x=6");
            T1.displayTree();
            System.out.println("Result for x = 6 : " + T1.evaluate());
            // The setVariable function does not do anything
            // since y does not exist in the expression and
            // the evaluate function uses the most recent value of x,
            AlgExpressionTree T2 ;
            T2= new AlgExpressionTree("++y9z");
            
            T2.setVariable('y',9);
            
            System.out.print("Result for y = 9 : " + T2.evaluate());
            
            System.out.println();
            // Print the tree in postfix form
            System.out.print("Postfix form of +*3x5:  ");
            
            T1.displayPostfix();
            System.out.println();
            System.out.println("Tree for postfix expression");
            T1.displayTree();
            System.out.println();
            // Evaluate the expression for z = 10
            // Note: uses the default value for y, which is 0
            System.out.println(" Tree for ++y9z expression");
            System.out.println();
            T2= new AlgExpressionTree("++y9z");
            T2.displayTree();
            T2.setVariable('z',2);
            System.out.println("Tree when z=2 ");
            System.out.println();
            T2.displayTree();
            System.out.println("Result for z = 2 : " + T2.evaluate());
            T2.setVariable('y', 3);
            
            System.out.println("Tree for when y=3");
            System.out.println();
            T2.displayTree();
     
      
            System.out.println("Result for y = 3 : " + T2.evaluate());
            // Evaluates the expression when y=3
            
      }

}

