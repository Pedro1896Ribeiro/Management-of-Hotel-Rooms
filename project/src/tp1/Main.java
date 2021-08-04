package tp1;


public class Main {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args){
        
        Hotel hotel = new Hotel();
        
        /**
         * Adicionar Quartos
         */
        hotel.addQuarto(2, 10);
        hotel.addQuarto(3, 20);
        hotel.addQuarto(4, 30);
        hotel.addQuarto(5, 40);

        /**
         * Adicionar Clientes
         */
        hotel.addCliente("Joana");
	hotel.addCliente("Pedro");
	hotel.addCliente("Sofia");
	hotel.addCliente("Miguel");

        /**
         * Registo de Hospedagens
         */
        hotel.quartosDesocupadosToString();

	hotel.hospedar(1, 1, 0);
	hotel.hospedar(4, 2, 50);
	hotel.hospedar(2, 3, 10);
        
        hotel.quartosDesocupadosToString();
        
        System.out.println(hotel.checkOut(1));
	System.out.println(hotel.checkOut(4));
	System.out.println(hotel.checkOut(2));
        
        System.out.println(hotel.totalFaturadoAoCliente(1));
	System.out.println(hotel.totalFaturadoAoCliente(2));
	System.out.println(hotel.totalFaturadoAoCliente(3));

        /**
         * Visualizacao das Hospedagens
         */
        System.out.println(hotel.hospedagensDeClienteToString(1));
        System.out.println(hotel.hospedagensDeClienteToString(2));
        System.out.println(hotel.hospedagensDeClienteToString(3));
    }
}
