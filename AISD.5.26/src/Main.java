public class Main {
    public static void main(String[] args) {
        Tree<Integer> tree = new Tree<>(1);
        Tree.TreeNode<Integer> node2 = tree.addLeftChild(((Tree<Integer>) tree).root, 2);
        Tree.TreeNode<Integer> node3 = tree.addRightChild(tree.root, 3);
        Tree.TreeNode<Integer> node4 = tree.addLeftChild(node2, 4);
        Tree.TreeNode<Integer> node5 = tree.addRightChild(node2, 5);

        System.out.println("Прямой обход:");
        tree.preOrderTraversal(data -> System.out.print(data + " "));
        System.out.println();

        System.out.println("Обратный обход:");
        tree.postOrderTraversal(data -> System.out.print(data + " "));
        System.out.println();

        System.out.println("Симметричный обход:");
        tree.inOrderTraversal(data -> System.out.print(data + " "));
        System.out.println();
    }
}