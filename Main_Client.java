import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class ClientMain {
    public static void main(String[] args) {
        try {
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            RemoteInterface stub = (RemoteInterface) registry.lookup("RemoteInterface");

            int idade = stub.calcularIdade(1995);
            System.out.println("Idade: " + idade);

          
            int maior = stub.maiorNumero(10, 20);
            System.out.println("Maior número: " + maior);

            
            int[] vetor = {1, 5, 7, 3, 8};
            int maiorVetor = stub.maiorDoVetor(vetor);
            System.out.println("Maior número do vetor: " + maiorVetor);

            
            int[][][] paralelepipedo = new int[256][256][256];
            Random random = new Random();
            for (int i = 0; i < 256; i++) {
                for (int j = 0; j < 256; j++) {
                    for (int k = 0; k < 256; k++) {
                        paralelepipedo[i][j][k] = random.nextInt(101); 
                    }
                }
            }
            int numPrimos = stub.contarPrimosNoParalelepipedo(paralelepipedo);
            System.out.println("Quantidade de números primos: " + numPrimos);

            
            byte[][][] imagem3D = new byte[256][256][256];
            for (int i = 0; i < 256; i++) {
                for (int j = 0; j < 256; j++) {
                    for (int k = 0; k < 256; k++) {
                        imagem3D[i][j][k] = (byte) random.nextInt(256); 
                    }
                }
            }
            int[] histograma = stub.gerarHistograma3D(imagem3D);
            System.out.println("Histograma gerado:");

            for (int i = 0; i < histograma.length; i++) {
                System.out.println("Valor " + i + ": " + histograma[i]);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
