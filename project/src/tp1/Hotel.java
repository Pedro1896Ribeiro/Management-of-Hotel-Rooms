package tp1;

import java.util.TreeMap;

/**
 *
 * @author Nuno Barreira, A37553, Eng.Informatica
 * @author Pedro Ribeiro, A37557, Eng.Informatica
 * 
 */
public class Hotel {
    
    private TreeMap< Integer, Cliente> clientes;
    private TreeMap< Integer, Quarto> quartos;
    
    public Hotel(){
        clientes = new TreeMap<>();
        quartos = new TreeMap<>();
    }
    
    /**
     *
     * @param camas Camas
     * @param preco Preço
     */
    public void addQuarto(int camas, double preco){
        Quarto quart = new Quarto(quartos.size() + 1, camas, preco);
        quartos.put(quartos.size() + 1, quart);
    }
    
    /**
     *
     * @param nome Nome Cliente
     */
    public void addCliente(String nome){
        Cliente client = new Cliente(clientes.size() + 1, nome);
        clientes.put(clientes.size() + 1, client);
    }
    
    /**
     *
     * @param quarto ID Quarto
     * @param cliente ID Cliente
     * @param txdesc Taxa de Desconto
     * @return True se houver quartos para hospedar; False se o quarto estiver ocupado
     */
    public boolean hospedar(int quarto, int cliente, double txdesc){
        Quarto q = quartos.get(quarto);
        
        if (q != null) {
            Cliente c = clientes.get(cliente);
            if (c != null) {
                if (!q.ocupado()){
                    q.hospedar(c, txdesc);
                }
            }
        }
        return false;
        
    }
    
    /**
     *
     * @param quarto ID Quarto
     * @return Checkout
     */
    public double checkOut(int quarto){
        Quarto q = quartos.get(quarto);
        
        if (q != null){
            if (q.ocupado()){
                return q.checkOut();
            }else {
                System.out.println("Ja se encontra desocupado.");
            }
        }
        else System.out.println("Quarto nao existe.");
        return 0;
    }
    
    /**
     *
     * @return Quartos desocupados
     */
    public String quartosDesocupadosToString(){
        System.out.println("Quartos desocupados: ");
        
        for (int i = 1; i <= quartos.size(); i++){
            Quarto q = quartos.get(i);
            if (!q.ocupado()){
                System.out.println("Quarto:" + q.getNum());
            }
        }return "Nao existe mais quartos desocupados.";
    }
   
    /**
     *
     * @param id ID Cliente
     * @return Hospedagens do Cliente
     */
    public String hospedagensDeClienteToString(int id){
       Cliente c = clientes.get(id);
        
       return c.hospedagensToString();
    }
    
    /**
     *
     * @param id ID Cliente
     * @return Total Faturado por Cliente
     */
    public double totalFaturadoAoCliente(int id){
        Cliente c = clientes.get(id);
        
        double faturado = c.totalFaturado();
        System.out.println("Total faturado ao Cliente: " +id+ "Valor: " +faturado);
        return faturado;
    }
}