import javax.swing.JOptionPane;

public class FinalSwingLRT {
    
    private static Object[] transit = {"LRT 1", "LRT 2", "MRT 3"};
    private static Object[] pay = {"Regular Card", "Beep Card"};
    
    // Status constants for passenger type
    private static final int STATUS_REGULAR = 1;
    private static final int STATUS_STUDENT = 2;
    private static final int STATUS_PWD = 3;
    
    // Card constants for payment method
    private static final int CARD_REGULAR = 1;
    private static final int CARD_BEEP = 2;
    private static Object[] discount = {"Regular Passenger (10%)", "Student (15%)", "3-PWD (20%)"};
    private static Object[] options = {"Change Station", "Ride Again", "Get Off"};
    private static Object[] options2 = {"Ride Again", "Get Off"};
    
    private static int[][] LRT1Fares = {
        {0, 20, 20, 20, 25, 25, 25, 25, 25, 25, 30, 30, 30, 30, 30, 35, 35, 35, 35, 35}, //fpj
        {20, 0, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 30, 30, 30, 30, 30, 35, 35, 35}, // Balintawak
        {20, 20, 0, 15, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 30, 30, 30, 30, 30}, // Monumento
        {20, 20, 15, 0, 15, 15, 20, 20, 20, 20, 20, 20, 25, 25, 25, 25, 30, 30, 30, 30}, // 5th Ave
        {25, 20, 20, 15, 0, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 35, 35, 35}, // R. Papa
        {25, 20, 20, 15, 15, 0, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 30, 30}, // Abad Santos
        {25, 25, 20, 20, 15, 15, 0, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25, 30}, // Blumentritt
        {25, 25, 25, 20, 20, 15, 15, 0, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25, 25}, // Tayuman
        {25, 25, 20, 20, 20, 20, 15, 15, 0, 15, 15, 20, 20, 20, 20, 20, 25, 25, 25, 25}, // Bambang
        {25, 25, 20, 20, 20, 20, 20, 15, 15, 0, 15, 15, 20, 20, 20, 20, 25, 25, 25, 25}, // D. Jose
        {30, 25, 25, 20, 20, 20, 20, 20, 15, 15, 0, 15, 20, 20, 20, 20, 20, 25, 25, 25}, // Carriedo
        {30, 25, 25, 20, 20, 20, 20, 20, 20, 15, 15, 0, 15, 20, 20, 20, 20, 20, 25, 25}, // Central
        {30, 30, 25, 25, 25, 20, 20, 20, 20, 20, 20, 15, 0, 15, 15, 20, 20, 20, 20, 20}, // UN Avenue
        {30, 30, 25, 25, 25, 25, 20, 20, 20, 20, 20, 20, 15, 0, 15, 15, 20, 20, 20, 20}, // Pedro Gil
        {30, 30, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 15, 15, 0, 15, 20, 20, 20, 20}, // Quirino
        {35, 30, 30, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 15, 15, 0, 15, 15, 20, 20}, // Vito Cruz
        {35, 30, 30, 30, 25, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 15, 0, 15, 15, 20}, // Gil Puyat
        {33, 35, 30, 30, 30, 25, 25, 25, 25, 25, 25, 20, 20, 20, 20, 15, 15, 0, 15, 15}, // Libertad
        {35, 35, 30, 30, 30, 30, 25, 25, 25, 25, 25, 25, 20, 20, 20, 20, 15, 15, 0, 15}, // EDSA
        {35, 35, 30, 30, 30, 30, 30, 25, 25, 25, 25, 25, 20, 20, 20, 20, 20, 15, 15, 0} // Baclaran
    };
    
    private static int[][] LRT2Fares = {
        {0, 15, 20, 20, 20, 25, 25, 25, 25, 30, 30, 35, 35}, //Recto
        {15, 0, 15, 20, 20, 20, 25, 25, 25, 25, 30, 30, 35}, // Legarda
        {20, 15, 0, 15, 20, 20, 20, 20, 25, 25, 30, 30, 30}, // Pureza 
        {20, 20, 15, 0, 15, 20, 20, 20, 20, 25, 25, 30, 30}, // V. Mapa
        {20, 20, 20, 15, 0, 15, 20, 20, 20, 20, 25, 25, 30}, // J. Ruiz
        {25, 20, 20, 20, 15, 0, 15, 20, 20, 20, 25, 25, 30}, // Gilmore
        {25, 25, 20, 20, 30, 15, 0, 15, 20, 20, 20, 25, 25}, // Betty Go
        {25, 25, 20, 20, 20, 20, 15, 0, 15, 20, 20, 25, 25}, // Araneta
        {25, 25, 25, 20, 20, 20, 20, 15, 0, 15, 20, 20, 25}, // Anonas
        {30, 25, 25, 25, 20, 20, 20, 20, 15, 0, 20, 20, 25}, // Katipuan
        {30, 30, 30, 25, 25, 25, 20, 20, 20, 20, 0, 15, 20}, // Santolan
        {35, 30, 30, 30, 25, 25, 25, 25, 20, 20, 15, 0, 20}, // Marikina
        {35, 35, 30, 30, 30, 30, 25, 25, 25, 25, 20, 20, 0}, // Antipolo
    };
    
    private static int[][] MRT3Fares = {
        {0, 13, 13, 16, 16, 20, 20, 20, 24, 24, 24, 28, 28}, //North Avenue
        {13, 0, 13, 13, 16, 16, 20, 20, 20, 24, 24, 24, 28}, //Quezon Avenue
        {13, 13, 0, 13, 13, 16, 16, 20, 20, 20, 24, 24, 24}, //Kamuning
        {16, 13, 13, 0, 13, 13, 16, 16, 20, 20, 20, 24, 24}, //Cubao
        {16, 16, 13, 13, 0, 13, 13, 16, 16, 20, 20, 20, 24}, //Santolan-Annapolis
        {20, 16, 16, 13, 13, 0, 13, 13, 16, 16, 20, 20, 20}, //Ortigas
        {20, 20, 16, 16, 13, 13, 0, 13, 13, 16, 16, 20, 20}, //Shaw
        {20, 20, 20, 16, 16, 13, 13, 0, 13, 13, 16, 16, 20}, //Boni
        {24, 20, 20, 20, 16, 16, 13, 13, 0, 13, 13, 16, 16}, //Guadalupe
        {24, 24, 20, 20, 20, 16, 16, 13, 13, 0, 13, 13, 16}, //Buendia
        {24, 24, 24, 20, 20, 20, 16, 16, 13, 13, 0, 13, 13}, //Ayala
        {28, 24, 24, 24, 20, 20, 20, 16, 16, 13, 13, 0, 13}, //Magallanes
        {28, 28, 24, 24, 24, 20, 20, 20, 16, 16, 13, 13, 0}, //Taft
    };
    
    private static String[] station1 = {"Baclaran", "EDSA (Connecting MRT 3)", "Libertad", "Gil Puyat", "Vito Cruz", "Quirino", "Pedro Gil",
            "UN Ave.", "Central", "Carriedo", "Doroteo Jose  (Connecting LRT 2)", "Bambang", "Tayuman", "Blumentritt",
            "Abad Santos", "R. Papa", "5th Avenue", "Monumento", "Balintawak", "Roosevelt"};    
    private static String[] station2 = {"Recto (Connecting LRT 1)", "Legarda", "Pureza", "V. Mapa", "J. Ruiz", "Gilmore", "Betty Go-Belmonte",
            "Araneta - Cubao (Connecting MRT 3)", "Anonas", "Katipunan", "Santolan", "Marikina", "Antipolo"};    
    private static String[] station3 = {"North Ave", "Quezon Ave", "Kamuning", "Cubao (Connecting LRT 2)", "Santolan", "Ortigas", "Shaw",
            "Boni", "Guadalupe", "Buendia", "Ayala", "Magallanes", "Taft (Connecting LRT 1)"};
    
    private static void handleInvalidInput() {
        JOptionPane.showMessageDialog(null, "Error! Exiting App..");
        System.exit(0);
    }
    
    private static void paymentMessage(double payment){
        JOptionPane.showMessageDialog(null,"Total Payment " + payment);
    }
    
    public static void main(String[] args) {
        terminal();
    }
    
    public static void lrt1(double payment, int terminal,int initial,int finale,int card, int status, int ride, int transfer) {
        String lrtStart;
        if(transfer == 0)
            finale = initial; 
        else 
            initial = finale;
        int temp;
        if(ride==0){
            lrtStart = (String)JOptionPane.showInputDialog(
                null,
                "Welcome to LRT 1 Terminal (List of Stations):\n",
                "LRT 1 stations",
                JOptionPane.PLAIN_MESSAGE,
                null,
                station1,
                null);
            if(lrtStart == null)
                handleInvalidInput(); 
            for(temp = 0; temp < station1.length; temp++) {
                if(lrtStart.equals(station1[temp])){
                    initial = temp;
                    break;
                }
            }
        }
        else
            lrtStart = station1[initial];
        // Create a new array tempLRT to exclude the station chosen in lrtStart
        String[] tempLRT = new String[station1.length - 1]; // New array size will be one less than lrt1
        int index = 0;
        for (Object station : station1) {
            String tempStation = (String) station;
            if (!tempStation.equals(lrtStart)) 
                tempLRT[index++] = tempStation;
        }        
        String lrtEnd = (String) JOptionPane.showInputDialog(
            null,
            "From "+lrtStart+" to: ",
            "LRT 1 stations",
            JOptionPane.PLAIN_MESSAGE,
            null,
            tempLRT,
            null);
        if(lrtEnd == null)
            handleInvalidInput(); 
        for(temp = 0; temp < station1.length; temp++) {
            if(lrtEnd.equals(station1[temp])){
                finale = temp;
                break;
            }
        }
        double pricy;
        if(initial == finale) { 
            payment += 0; 
            pricy = 0; 
            transfer = 0; 
        }
        else {
            pricy = LRT1Fares[initial][finale]; 
            if(status == STATUS_REGULAR && card == CARD_BEEP) { 
                pricy = pricy * 0.90;
            }
            if(status == STATUS_STUDENT && card == CARD_BEEP) { 
                pricy = pricy * 0.85;
            }
            if(status == STATUS_PWD && card == CARD_BEEP) { 
                pricy = pricy * 0.80;
            }
            payment += pricy;
            transfer = 0;
        }
        JOptionPane.showMessageDialog(null,
            "Terminal 1 | From "+lrtStart+" To "+lrtEnd +" | Ride Fee: Php " + pricy);        
        int choose4 = -1, choose5 = -1;
        if(finale==1||finale==10){
            choose4 = JOptionPane.showOptionDialog(null,
                "Options",
                "Travel Options",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);
            if(choose4==-1)
                handleInvalidInput();
            if(choose4==0)
                transfer = 1;
        }
        else{
            choose5= JOptionPane.showOptionDialog(null,
                "Options",
                "Travel Options",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options2,
                null);
            if(choose5==-1)
                handleInvalidInput();
        }
        if(transfer == 1) { 
            if(finale == 1) {
                ride = 1;
                finale = 12;
                terminal = 3;
                lrt3(payment,terminal,initial,finale,card,status,ride,0);   
            }
            if(finale == 10) {
                ride = 1;
                terminal = 2;
                finale = 0;
                lrt2(payment,terminal,initial,finale,card,status,ride,0);   
            }
        } 
        else if(choose4==1||choose5==0) { 
            initial = finale;
            ride = 1;
            lrt1(payment,terminal,initial,finale,card,status,ride,transfer); 
        }
        else 
            paymentMessage(payment);
    }

    public static void lrt2(double payment, int terminal,int initial,int finale,int card, int status, int ride, int transfer) {
        String lrtStart;
        if(transfer == 0)
            finale = initial; 
        else 
            initial = finale; 
        int temp;
        if(ride==0){
            lrtStart = (String)JOptionPane.showInputDialog(
                null,
                "Welcome to LRT 2 Terminal (List of Stations):\n",
                "LRT 2 stations",
                JOptionPane.PLAIN_MESSAGE,
                null,
                station2,
                null);
            if(lrtStart == null)
                handleInvalidInput(); 
            for(temp = 0; temp < station2.length; temp++) {
                if(lrtStart.equals(station2[temp])){
                    initial = temp;
                    break;
                }
            } 
        }
        else
            lrtStart = station2[initial];
        // Create a new array tempLRT to exclude the station chosen in lrtStart
        String[] tempLRT = new String[station2.length - 1]; // New array size will be one less than lrt1
        int index = 0;
        for (Object station : station2) {
            String tempStation = (String) station;
            if (!tempStation.equals(lrtStart)) 
                tempLRT[index++] = tempStation;
        } 
        String lrtEnd = (String) JOptionPane.showInputDialog(
            null,
            "From "+lrtStart+" to: ",
            "LRT 2 stations",
            JOptionPane.PLAIN_MESSAGE,
            null,
            tempLRT,
            null);
        if(lrtEnd == null)
            handleInvalidInput(); 
        for(temp = 0; temp < station2.length; temp++) {
            if(lrtEnd.equals(station2[temp])){
                finale = temp;
                break;
            }
        }
        double pricy;
        if(initial == finale) { 
            payment += 0; 
            pricy = 0; 
            transfer = 0; 
        }
        else {
            pricy = LRT2Fares[initial][finale]; 
            if(status == STATUS_REGULAR && card == CARD_BEEP) { 
                pricy = pricy * 0.90;
            }
            if(status == STATUS_STUDENT && card == CARD_BEEP) { 
                pricy = pricy * 0.85;
            }
            if(status == STATUS_PWD && card == CARD_BEEP) { 
                pricy = pricy * 0.80;
            }
            payment += pricy;
            transfer = 0;
        }
        JOptionPane.showMessageDialog(null,
            "Terminal 2 | From "+lrtStart+" To "+lrtEnd +" | Ride Fee: Php " + pricy);
        int choose4 = -1, choose5 = -1;
        if(finale==0||finale==7){
            choose4 = JOptionPane.showOptionDialog(null,
                "Options",
                "Travel Options",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);
            if(choose4==-1)
                handleInvalidInput();
            if(choose4==0)
                transfer = 1;
        }
        else{
            choose5= JOptionPane.showOptionDialog(null,
                "Options",
                "Travel Options",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options2,
                null);
            if(choose5==-1)
                handleInvalidInput();
        }
        if(transfer == 1) { 
            if(finale == 0){
                ride = 1;
                finale = 10;
                terminal = 1;
                lrt1(payment,terminal,initial,finale,card,status,ride,transfer);   
            }            
            if(finale == 7){
                ride = 1;
                terminal = 3;
                finale = 3;
                lrt3(payment,terminal,initial,finale,card,status,ride,transfer);   
            }
        } 
        else if(choose4==1||choose5==0) { 
            initial = finale;
            ride = 1;
            lrt2(payment,terminal,initial,finale,card,status,ride,transfer);             
        }
        else 
            paymentMessage(payment);         
    }

    public static void lrt3(double payment, int terminal,int initial,int finale,int card, int status, int ride, int transfer){
        String lrtStart;
        if(transfer == 0)  
            finale = initial;  
        else  
            initial = finale; 
        int temp;
        if(ride==0){
            lrtStart = (String)JOptionPane.showInputDialog(
                null,
                "Welcome to MRT 3 Terminal (List of Stations):\n",
                "MRT 3 stations",
                JOptionPane.PLAIN_MESSAGE,
                null,
                station3,
                null);
            if(lrtStart == null)
                handleInvalidInput(); 
            for(temp = 0; temp < station3.length; temp++) {
                if(lrtStart.equals(station3[temp])){
                    initial = temp;
                    break;
                }
            }        
        }
        else
            lrtStart = station3[initial];
        // Create a new array tempLRT to exclude the station chosen in lrtStart
        String[] tempLRT = new String[station3.length - 1]; // New array size will be one less than lrt1
        int index = 0;
        for (Object station : station3) {
            String tempStation = (String) station;
            if (!tempStation.equals(lrtStart)) 
                tempLRT[index++] = tempStation;
        }
        String lrtEnd = (String) JOptionPane.showInputDialog(
            null,
            "From "+lrtStart+" to: ",
            "MRT 3 stations",
            JOptionPane.PLAIN_MESSAGE,
            null,
            tempLRT,
            null);
        if(lrtEnd == null)
            handleInvalidInput();        
        for(temp = 0; temp < station3.length; temp++) {
            if(lrtEnd.equals(station3[temp])){
                finale = temp;
                break;
            }
        }
        double pricy;
        if(initial == finale) { 
            payment += 0; 
            pricy = 0; 
            transfer = 0; 
        }
        else {
            pricy = MRT3Fares[initial][finale];
            if(status == STATUS_REGULAR && card == CARD_BEEP) { 
                pricy = pricy * 0.90;
            }
            if(status == STATUS_STUDENT && card == CARD_BEEP) { 
                pricy = pricy * 0.85;
            }
            if(status == STATUS_PWD && card == CARD_BEEP) { 
                pricy = pricy * 0.80;
            }
            payment += pricy;
            transfer = 0;
        }
        JOptionPane.showMessageDialog(null,
            "Terminal 3 | From "+lrtStart+" To "+lrtEnd +" | Ride Fee: Php " + pricy);
        int choose4 = -1, choose5 = -1;
        if(finale==3||finale==12){
            choose4 = JOptionPane.showOptionDialog(null,
                "Options",
                "Travel Options",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                null);
            if(choose4==0)
                transfer = 1;
            if(choose4==-1)
                handleInvalidInput();
        }
        else{
           choose5= JOptionPane.showOptionDialog(null,
                "Options",
                "Travel Options",
                JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                options2,
                null);
            if(choose5==-1)
                handleInvalidInput();
        }
        if(transfer == 1) { 
            if(finale == 3){
                ride = 1;
                finale = 7;
                terminal = 2;
                lrt2(payment,terminal,initial,finale,card,status,ride,transfer);   
            }
            if(finale == 12){
                ride = 1;
                terminal = 1;
                finale = 1;
                lrt1(payment,terminal,initial,finale,card,status,ride,transfer);   
            }
        } 
        else if(choose4==1||choose5==0) { 
            initial = finale;
            ride = 1;
            lrt3(payment,terminal,initial,finale,card,status,ride,transfer); 
        }
        else  
            paymentMessage(payment); 
    }
    
    public static void terminal() {
        double payment = 0;
        int initial = 0, finale = 0, ride = 0, transfer = 0;
        JOptionPane.showMessageDialog(null,
                    "Welcome to LRT/MRT Stations");
        int terminal = JOptionPane.showOptionDialog(null,
                        "Terminal Station (LRT 1 | LRT 2 | MRT 3)",
                        "LRT/MRT Stations",
                        JOptionPane.YES_NO_CANCEL_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        transit,
                        null);
        if(terminal==-1)
            handleInvalidInput();
        int card  = JOptionPane.showOptionDialog(null,
            "Terminal Station ( Regular Card | Beep Card)",
            "Payment",
            JOptionPane.YES_NO_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            pay,
            null);
        if(card==-1)
            handleInvalidInput();
        int status = 0;
        if(card == 1){
            status = JOptionPane.showOptionDialog(null,
                "Terminal Station (Regular Passenger (10%) | Student (15%) | PWD (20%))",
                "Discount",
                JOptionPane.YES_NO_CANCEL_OPTION,
                JOptionPane.QUESTION_MESSAGE,
                null,
                discount,
                null);
            if(status==-1)
                handleInvalidInput();
        }
        switch (terminal) {
            case 0 -> lrt1(payment,terminal,initial,finale,card,status,ride,transfer);
            case 1 -> lrt2(payment,terminal,initial,finale,card,status,ride,transfer);
            case 2 -> lrt3(payment,terminal,initial,finale,card,status,ride,transfer);
            default -> JOptionPane.showMessageDialog(null, "Invalid selection");
        }
    }
}
