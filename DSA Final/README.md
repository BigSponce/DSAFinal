Application Theory

1. Why does an inorder traversal of a BST return sorted results?
A. Traversal follows a strict "left, root, right" order but for this project and the idea of priorities, I flipped the order showing "right, root, left".

2. What happens to the tree when you insert values in order (1,2,3,4,5)?
A. Inserting values like this results in an unbalanced tree. 1 would be the root, and with each number being greater they would all be placed to the right.

3. Where would you place duplicate priority values in your tree?
A. In the current version of this project, they would be placed in the right subtree.

4. Explain how your sorting algorithm works step-by-step using a small example.
A. For example, given the set (4,2,5,1,3) they would be placed in order with 4 as the root, 2 goes left, 5 goes right, 1 goes left of 2 and 3 goes right of 2.

5. What is the time complexity of your algorithm?
A. In a balanced set of data, building the tree would be O(n log n). Unbalanced it becomes O(n^2) Reading is O(n) either way.

6. When would your sorting algorithm perform well?
A. With a balanced set of sample data or with data being in a random or unsorted manner.

7. Why is your sorting algorithm ideal or not ideal for very large datasets?
A. A basic BST doesn't work well with large datasets. The larger number of sample datasets has a higher chance of unbalancing the tree. In the event of larger datasets being sent in, the BST would have to change to a different type of sorting like a Red-Black tree or AVL tree.

8. Why might you choose to sort data in your application instead of the database?
A. There's a number of reasons why to sort data, but in this case it's beneficial to see what orders have the highest priority and need to be filled first.

9. What is one advantage of using a BST in this system?
A. The most significant advantage would be in finding the highest and lowest priority orders.

10. What is one limitation of your current design?
A. The BST isn't synchronized across multiple instances so it only exists in the memory of a single application.

I used AI sparingly, mainly to generate sample data and troubleshoot any problems compiling the project. For some reason I had some major problems with Maven sync.
