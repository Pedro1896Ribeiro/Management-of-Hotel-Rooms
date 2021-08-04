package tp1;

import java.util.LinkedHashSet;


public class Cliente {
    
    private int id;
    private String nome;
    private LinkedHashSet<Hospedagem> hospedagens;
    
    /**
     *
     * @param i ID Cliente
     * @param n Nome Cliente
     */
    public Cliente(int i, String n){
        id = i;
        nome = n;
        hospedagens = new LinkedHashSet<>();
    }
    
    /**
     *
     * @param h Hospedagem Cliente
     */
    public void hospedar(Hospedagem h){
        hospedagens.add(h);
    }
    
    /**
     *
     * @return ID Cliente, Nome Cliente, Hospedagem Cliente
     */
    public String hospedagensToString(){
        return "\n   -> Cliente"
                + "\nID Cliente: " + id + "\nNome: " + nome + "\n" + hospedagens.toString();
    }
    
    /**
     *
     * @return Total Faturado ao Cliente
     */
    public double totalFaturado(){
        double soma = 0;
        
        for(Hospedagem h: hospedagens)
            soma += h.getCusto();
        return soma;
    }
}
