package tp1;

import java.util.LinkedHashSet;


public class Quarto {
    
    private int num;
    private int camas;
    private double precoDiario;
    private Hospedagem hospedagemAtual;
    private LinkedHashSet<Hospedagem> hospedagens;
    private LinkedHashSet<Cliente> clientes;
    
    /**
     *
     * @param n ID Quarto
     * @param c Camas
     * @param preco Preço do Quarto
     */
    public Quarto(int n, int c, double preco){
        num = n;
        camas = c;
        precoDiario = preco;
        hospedagens = new LinkedHashSet<>();
        clientes = new LinkedHashSet<>();
    }
    
    /**
     *
     * @return True se o quarto não estiver desocupado; False se o quarto estiver desocupado
     */
    public boolean ocupado(){
        if (hospedagemAtual == null){
            return false;
        }
        else{
            return true;
        }
    }
    
    /**
     *
     * @return ID Quarto
     */
    public int getNum(){
        return num;
    }
    
    /**
     *
     * @return Preço Diário
     */
    public double getPrecoDiario(){
        return precoDiario;
    }
    
    /**
     *
     * @param c Camas
     * @param txdesc Taxa de Desconto
     * @return True hospedar; False não hospedar
     */
    public boolean hospedar(Cliente c, double txdesc){
        Hospedagem h = new Hospedagem (txdesc,this,c);
        if (hospedagens.add(h)){
            c.hospedar(h);
            hospedagemAtual = h;
            return true;
        }else
            return false;   
    }
     
    /**
     *
     * @return Custo do Checkout
     */
    public double checkOut(){
        double custoCheckout;
        
        custoCheckout = hospedagemAtual.checkOut();
        System.out.println("Custo total:");
        hospedagemAtual = null;
        return custoCheckout;
        
    }
    
    /**
     * 
     * @return ID Quarto, Camas, Preço Diário
     */
    @Override
    public String toString(){
        return "   -> Quarto\n" + "ID Quarto: " + num
                + "\nCamas: " + camas + "\nPreco Diario: " 
                + precoDiario+ "€\n";
    
    }
}