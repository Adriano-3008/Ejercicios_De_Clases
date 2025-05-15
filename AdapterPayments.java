

/*
 @startuml

interface PaymentGateway{
pay(amount:double)
}

class LegacyPaymentServiceAdapter{
-creditCard:CreditCard
-legacyPaymentService:LegacyPaymentService
+pay(amount:double):boolean
+LegacyPaymentServiceAdapter(creditCard: CreditCard, LegacyPaymentService:LegacyPaymentService):void
}

class ProcessPayment{
-creditCard:CreditCard
+payment(amount:double);boolean
}

class LegacyPaymentService{
+makePayment(number:String, secureCode:int, valid:String, name:String, amount:double):boolean
}

class CreditCard{
-number:String
-secureCode:int
-valid:String
-name:String
+getNumber():String
+getSecureCode():int
+getValid():String
+getName():String
+authorize():boolean
+process(amount:double):boolean
}

PaymentGateway <|.. LegacyPaymentServiceAdapter
LegacyPaymentServiceAdapter *-- CreditCard
ProcessPayment <-- CreditCard
LegacyPaymentServiceAdapter *-- LegacyPaymentService

@enduml
 */

interface PaymentGateway {
        boolean pay(double amount);
}

class LegacyPaymentServiceAdapter implements PaymentGateway{
    private CreditCard creditCard;
    private LegacyPaymentService legacyPaymentService;
    public boolean pay(double amount){
        return legacyPaymentService.makePayment(creditCard.getNumber(), creditCard.getValid(), creditCard.getName(), creditCard.getSecureCode(), amount); 
    }
    public void legacyPaymentServiceAdapter(LegacyPaymentService legacyPaymentService, CreditCard creditCard){
        this.legacyPaymentService = legacyPaymentService;
        this.creditCard = creditCard;

    }

}

class ProcessPayment{
    private CreditCard creditCard;
    public boolean payment(double amount){
        
        if(creditCard.authorize()){
            return creditCard.process(amount);
        }else{
            return false;
        }
    }
}

class CreditCard{
    private String number;
    private String valid;
    private String name;
    private int secureCode;
    public CreditCard(String number, String valid, String name, int secureCode) {
        
        this.number = number;
        this.valid = valid;
        this.name = name;
        this.secureCode = secureCode;
    }
    public String getNumber() {
        
        return number;
    }
    public String getValid() {
        
        return valid;
    }
    public String getName() {
        
        return name;
    }
    public int getSecureCode() {
        
        return secureCode;
    }
    public boolean authorize(){
   
        return true; 

    }
    public boolean process(double amount){

        System.out.println("Procesando el pago de " + amount + " usando la tarjeta de crédito: " + number);
        return true;

    }
}

class LegacyPaymentService{
    public boolean makePayment(String number, String valid, String name, int secureCode, double amount){

        System.out.println("Procesando el pago de " + amount + " usando el servicio heredado con la tarjeta: " + number);
        return true; 
    }

}


public class AdapterPayments {
    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard("8392746150382961", "12/27", "Vladimir Cortes", 2730);

        LegacyPaymentService legacyPaymentService = new LegacyPaymentService();

        // Crear un adaptador 
        LegacyPaymentServiceAdapter adapter = new LegacyPaymentServiceAdapter();
        adapter.legacyPaymentServiceAdapter(legacyPaymentService, creditCard);

        
        double amount = 150.75; 
        boolean paymentSuccessful = adapter.pay(amount);

        if (paymentSuccessful) {
            System.out.println("El pago se procesó exitosamente.");
        } else {
            System.out.println("El pago falló.");
        }
    }

}