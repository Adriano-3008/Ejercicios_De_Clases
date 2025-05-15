/*
 @startuml
class Cajero {
-monto:double
-saldo:double
+Cajero(monto:double)
+getMonto():double
+getSaldo():double
+retirar():void
}

class FondosInsuficientesException{
+FondosInsuficientesException(message:String)
}

class EjercicioCajeroYExcepciones{
+main(String[] args):void
}

EjercicioCajeroYExcepciones --> Cajero
Cajero --o FondosInsuficientesException
FondosInsuficientesException --o EjercicioCajeroYExcepciones
@enduml

 */



class Cajero {
    private double Monto;
    private double Saldo;

    public Cajero(double Monto) {
        this.Monto = Monto;
        this.Saldo = 100000;
    }
    public  double getMonto() {
        return Monto;
    }
    public  double getSaldo() {
        return Saldo;
    }
    
    public void retirar() throws FondosInsuficientesException {
        if (getMonto() > getSaldo()) {
            throw new FondosInsuficientesException("Fondos insuficientes");
        } else {
            Saldo -= Monto;
            System.out.println("Retiro exitoso.");
            System.out.println("Saldo restante: " + Saldo); 
        }
    }
}

class FondosInsuficientesException extends Exception {
    public FondosInsuficientesException(String message) {
        super(message);
    }
}

public class EjercicioCajeroYExcepciones {
    public static void main(String[] args) {
        Cajero cajero = new Cajero(1000);
        System.out.println("");
        System.out.println("Bienvenido al cajero.");
        System.out.println("Monto: " + cajero.getMonto());
        System.out.println("Saldo: " + cajero.getSaldo());
        try {
            cajero.retirar();
        } catch (FondosInsuficientesException e) {
            System.out.println("Error: " + e.getMessage());
        }
        finally {
            System.out.println("Gracias por usar este cajero.");
        }
        System.out.println("");
    }
}
