import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RemoteInterface extends Remote {
    int calcularIdade(int anoNascimento) throws RemoteException;
    int maiorNumero(int a, int b) throws RemoteException;
    int maiorDoVetor(int[] vetor) throws RemoteException;
    int contarPrimosNoParalelepipedo(int[][][] paralelepipedo) throws RemoteException;
    int[] gerarHistograma3D(byte[][][] imagem3D) throws RemoteException;
}
