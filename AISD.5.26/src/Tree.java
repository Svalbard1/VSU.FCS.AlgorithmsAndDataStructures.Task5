import java.util.Stack;

public class Tree<T> {
    TreeNode<T> root;

    static class TreeNode<T> {
        private T data;
        private TreeNode<T> left;
        private TreeNode<T> right;

        public TreeNode(T data) {
            this.data = data;
        }
    }

    public Tree(T rootData) { // создание дерева с корневым элементом
        root = new TreeNode<>(rootData);
    }

    public TreeNode<T> addLeftChild(TreeNode<T> node, T childData) { // добавляем левого потомка
        TreeNode<T> childNode = new TreeNode<>(childData);
        node.left = childNode;
        return childNode;
    }

    public TreeNode<T> addRightChild(TreeNode<T> node, T childData) { // добавляем правого потомка
        TreeNode<T> childNode = new TreeNode<>(childData);
        node.right = childNode;
        return childNode;
    }

    public void preOrderTraversal(Visitor<T> visitor) { // прямой обход дерева
        if (root == null) {
            return;
        }

        Stack<TreeNode<T>> stack = new Stack<>(); // в стеке мы хроним узлы которые не посетили
        stack.push(root);

        while (!stack.isEmpty()) {
            TreeNode<T> node = stack.pop(); // добавляем корневой узел в стек
            visitor.visit(node.data);

            if (node.right != null) { // есть правый, то в стек
                stack.push(node.right);
            } // правый добавляем раньше чтобы сохранить порядок обхода
            if (node.left != null) { // есть левый, то в стек
                stack.push(node.left);
            }
        }
    }

    public void postOrderTraversal(Visitor<T> visitor) { // обратный обход дерева
        if (root == null) {
            return;
        }
// работает так же как и preOrderTraversal, но имеет ещё один стек для того чтобы сделать обратный порядок
        Stack<TreeNode<T>> stack1 = new Stack<>();
        Stack<TreeNode<T>> stack2 = new Stack<>();
        stack1.push(root);

        while (!stack1.isEmpty()) {
            TreeNode<T> node = stack1.pop();
            stack2.push(node);

            if (node.left != null) {
                stack1.push(node.left);
            }
            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            TreeNode<T> node = stack2.pop();
            visitor.visit(node.data);
        }
    }

    public void inOrderTraversal(Visitor<T> visitor) { // симметричный обход
        if (root == null) {
            return;
        }

        Stack<TreeNode<T>> stack = new Stack<>();
        TreeNode<T> current = root;

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.pop();
            visitor.visit(current.data);
            current = current.right;
        }
    }
}

