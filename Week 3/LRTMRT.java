import java.awt.Component;
import java.awt.Dimension;
import javax.swing.JOptionPane;
import javax.swing.UIManager;
 
public class LRTMRT {
    
    public static void main(String[] args) {
        
        UIManager.put("OptionPane.minimumSize", new Dimension(350,150));
        
        Object[] lrt1 = {"Baclaran", "EDSA", "Libertad", "Gil Puyat", "Vito Cruz", 
                        "Quirino Avenue", "Pedro Gil", "United Nations", 
                        "Central Terminal", "Carriedo", "Doroteo Jose", "Bambang", 
                        "Tayuman", "Blumentritt", "Abad Santos", "R. Papa", 
                        "5th Avenue", "Monumento"};

        Object[] lrt2 = {"Recto", "Legarda", "Pureza", "V.Mapa", "J.Ruiz", 
                        "Gilmore", "Betty Go-Belmonte", "Cubao", "Anonas", 
                        "Katipunan", "Santolan", "Marikina-Pasig", "Antipolo"};

        Object[] mrt3 = {"Taft", "Magallanes", "Ayala", "Buendia", "Guadalupe", 
                        "Boni", "Shaw Boulevard", "Ortigas", "Santolan", "Cubao", 
                        "Kamuning", "Quezon Avenue", "North Avenue"};
        
        int []fare1BC = {13,14,15,16,17,18,19,20,22,23,23,24,25,26,27,28,29,30};
        int []fare1SJ = {15,15,20,20,20,20,20,25,25,25,25,25,30,30,30,30,30,30}; 
        int []fare2BC = {13,15,16,18,19,21,22,23,25,26,28,31,33};
        int []fare2SJ = {15,20,20,20,25,25,25,25,30,30,35,35,35};
        int []fare3 = {13,13,16,16,20,20,20,24,24,24,28,28,28};
                
        int transfer = 0;
        int choose1;
        int choose2;
        double totalfare = 0;
        Object[] terminal = {"LRT 1", "LRT 2", "MRT 3"};
        Object[] payment = {"Beep Card", "Single Journey"};
        Object[] options = {"Transfer", "Exit"};
        Component frame = null;
        
        JOptionPane.showMessageDialog(frame,
                    "Welcome to the Philippine Railways Fare Calculator");
        
        while(transfer==0){
            transfer = 1;
            choose1 = JOptionPane.showOptionDialog(frame,
            "Choose what terminal you are right now.",
            "Philippine Railways Fare Calculator",
            JOptionPane.YES_NO_CANCEL_OPTION,
            JOptionPane.QUESTION_MESSAGE,
            null,
            terminal,
            null);
            choose2 = JOptionPane.showOptionDialog(frame,
                        "Choose the method of payment",
                        "Payment Options",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        payment,
                        null);
            switch (choose1) {
                case 0 -> {
                    String lrtStart = (String)JOptionPane.showInputDialog(
                        frame,
                        "Choose the station you are right now:\n",
                        "LRT 1 Stations",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        lrt1,
                        null);
                    int num = 0;
                    for (int i = 0; i < lrt1.length; i++) {
                        if (lrt1[i].equals(lrtStart))
                            num = i;
                    }   
                    String lrtEnd = (String)JOptionPane.showInputDialog(
                        frame,
                        "Choose the station you want to go:\n",
                        "LRT 1 stations",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        lrt1,
                        null);
                    int num2 = 0;
                    for (int j = 0; j < lrt1.length; j++) {
                        if (lrt1[j].equals(lrtEnd))
                            num2 = j;
                    }   
                    int stationDiff = Math.abs(num2-num);
                    switch(choose2){
                        case 0 -> {
                            totalfare = totalfare + fare1BC[stationDiff];
                            JOptionPane.showMessageDialog(frame,
                                "Your total fare is " + totalfare + " pesos.");
                        }
                        case 1 -> {
                            totalfare = totalfare + fare1SJ[stationDiff];
                            JOptionPane.showMessageDialog(frame,
                                "Your total fare is " + totalfare + " pesos.");
                        } 
                    }
                    if(num2==1 || num2==10){
                        transfer = JOptionPane.showOptionDialog(frame,
                            "Do you want to transfer",
                            "Transfer Station",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            null);
                    }
                }
                case 1 -> {
                    String lrt2Start = (String)JOptionPane.showInputDialog(
                        frame,
                        "Choose the station you are right now:\n",
                        "LRT 2 Stations",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        lrt2,
                        null);
                    int num = 0;
                    for (int i = 0; i < lrt2.length; i++) {
                        if (lrt2[i].equals(lrt2Start))
                            num = i;
                    }   
                    String lrt2End = (String)JOptionPane.showInputDialog(
                        frame,
                        "Choose the station you want to go:\n",
                        "LRT 2 stations",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        lrt2,
                        null);
                    int num2 = 0;
                    for (int j = 0; j < lrt2.length; j++) {
                        if (lrt2[j].equals(lrt2End))
                            num2 = j;
                    }   
                    int stationDiff = Math.abs(num2-num);
                    switch(choose2){
                        case 0 -> {
                            totalfare = totalfare + fare2BC[stationDiff];
                            JOptionPane.showMessageDialog(frame,
                                "Your total fare is " + totalfare + " pesos.");
                        }
                        case 1 -> {
                            totalfare = totalfare + fare2SJ[stationDiff];
                            JOptionPane.showMessageDialog(frame,
                                "Your total fare is " + totalfare + " pesos.");
                        } 
                    }
                    if(num2==0 || num2==7){
                        transfer = JOptionPane.showOptionDialog(frame,
                            "Do you want to transfer",
                            "Transfer Station",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            null);
                    }
                }
                case 2 -> {
                    String mrt3Start = (String)JOptionPane.showInputDialog(
                        frame,
                        "Choose the station you are right now:\n",
                        "MRT 3 Stations",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        mrt3,
                        null);
                    int num = 0;
                    for (int i = 0; i < mrt3.length; i++) {
                        if (mrt3[i].equals(mrt3Start))
                            num = i;
                    }   
                    String mrt3End = (String)JOptionPane.showInputDialog(
                        frame,
                        "Choose the station you want to go:\n",
                        "MRT 3 stations",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        mrt3,
                        null);
                    int num2 = 0;
                    for (int j = 0; j < mrt3.length; j++) {
                        if (mrt3[j].equals(mrt3End))
                            num2 = j;
                    }   
                    int stationDiff = Math.abs(num2-num);
                    switch(choose2){
                        case 0 -> {
                            totalfare = totalfare + fare3[stationDiff];
                            JOptionPane.showMessageDialog(frame,
                                "Your total fare is " + totalfare + " pesos.");
                        }
                        case 1 -> {
                            totalfare = totalfare + fare3[stationDiff];
                            JOptionPane.showMessageDialog(frame,
                                "Your total fare is " + totalfare + " pesos.");
                        } 
                    }
                    if(num2==0 || num2==9){
                        transfer = JOptionPane.showOptionDialog(frame,
                            "Do you want to transfer",
                            "Transfer Station",
                            JOptionPane.YES_NO_OPTION,
                            JOptionPane.QUESTION_MESSAGE,
                            null,
                            options,
                            null);
                    }
                }
                default -> {
                    JOptionPane.showMessageDialog(frame,
                    "Error.");
                    break;
                }
            }
        }
        JOptionPane.showMessageDialog(frame, """
            You will now exit the Philippines Railways.
            Thank you for using the services""");
    }
}  