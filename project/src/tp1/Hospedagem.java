package tp1;

import java.text.SimpleDateFormat;
import java.util.Date;


public class Hospedagem {
    
    private static int numTotalHospedagens;
    private int id;
    private double txDesc;
    private double custoTotal;
    private Date checkin;
    private Date checkout;
    private Quarto quarto;
    private Cliente cliente;
    
    /**
     *
     * @param txdesc Taxa de desconto
     * @param q Quarto
     * @param c Cliente
     */
    public Hospedagem(double txdesc, Quarto q, Cliente c){
        txDesc = txdesc;
        numTotalHospedagens++;
        id = numTotalHospedagens;
        quarto = q;
        cliente = c;
        checkin = new Date();
        checkout = null;
    }
    
    /**
     *
     * @return Custo do Checkout
     */
    public double checkOut(){
        checkout = new Date();
        return getCusto();
    }
    
    /**
     *
     * @return Custo da Hospedagem
     */
    public double getCusto(){
        if (checkout == null) {
            return 0;
        }
        else {
            int ndayscheckin =(int) checkin.getTime() / (1000*60*60*24);
            int ndayscheckout =(int) checkout.getTime() / (1000*60*60*24);
            
            return (1 - (txDesc / 100)) * ((ndayscheckout - ndayscheckin) + 1) * quarto.getPrecoDiario();
        }
    }
    
    /**
     * Print dos dados da Hospedagem
     *
     * @return ID Hospedagem, Custo, Data, ID Quarto
     */
    public String toString(){
        return "\n   -> Hospedagem\n" + "ID Hospedagem: " + id
                + "\nCusto: " + getCusto() + "€" + "\nData da Hospedagem: "
                + (new SimpleDateFormat("dd/MM/yyyy")).format(checkin)
                + "\nNumero Quarto:" + quarto.getNum() + "\n";
    }
}
