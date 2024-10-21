import java.rmi.server.UnicastRemoteObject;
import java.time.Year;
import java.util.Random;

public class RemoteImpl extends UnicastRemoteObject implements RemoteInterface {

    public RemoteImpl() throws RemoteException {
        super();
    }

    @Override
    public int calcularIdade(int anoNascimento) throws RemoteException {
        int anoAtual = Year.now().getValue();
        return anoAtual - anoNascimento;
    }

    @Override
    public int maiorNumero(int a, int b) throws RemoteException {
        return Math.max(a, b);
    }

    @Override
    public int maiorDoVetor(int[] vetor) throws RemoteException {
        int maior = vetor[0];
        for (int i = 1; i < vetor.length; i++) {
            if (vetor[i] > maior) {
                maior = vetor[i];
            }
        }
        return maior;
    }

    @Override
    public int contarPrimosNoParalelepipedo(int[][][] paralelepipedo) throws RemoteException {
        int count = 0;
        for (int[][] plano : paralelepipedo) {
            for (int[] linha : plano) {
                for (int valor : linha) {
                    if (isPrime(valor)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    @Override
    public int[] gerarHistograma3D(byte[][][] imagem3D) throws RemoteException {
        int[] histograma = new int[256];
        for (byte[][] plano : imagem3D) {
            for (byte[] linha : plano) {
                for (byte voxel : linha) {
                    histograma[voxel & 0xFF]++;
                }
            }
        }
        return histograma;
    }

    private boolean isPrime(int num) {
        if (num < 2) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
