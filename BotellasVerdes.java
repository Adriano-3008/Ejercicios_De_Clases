public class BotellasVerdes {
    public static void main(String[] args) {
        for (int i = 10; i > 0; i--) {
            System.out.println(i + " botellas verdes están colgando en la pared.");
            System.out.println(i + " botellas verdes están colgando en la pared.");
            System.out.println("Si una botella se cae de la pared.");
            if (i - 1 > 0) {
                System.out.println((i - 1) + " botellas verdes colgando en la pared.\n");
            } else {
                System.out.println("Ya no hay botellas colgando en la pared.");
            }
        }
    }
}
