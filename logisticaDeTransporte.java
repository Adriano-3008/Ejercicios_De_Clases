interface Transporte{
    void gestionarEnvio();
}

abstract class Logistica {
abstract Transporte planificarEntrega();
}

class LogisticaMaritima extends Logistica{
    public Transporte planificarEntrega(){
        return new Barco();
    }

}

class LogisticaTerrestre extends Logistica{
    public Transporte planificarEntrega(){
        return new Camion();
    }

}

class LogisticaAerea extends Logistica{
    public Transporte planificarEntrega(){
        return new Avion();
    }

}

class Barco implements Transporte{
    public void gestionarEnvio(){
        System.out.println("Gestionando envío por barco.");
    }
    
}

class Camion implements Transporte{
    public void gestionarEnvio(){
        System.out.println("Gestionando envío por camión.");

    }
    
}

class Avion implements Transporte{
    public void gestionarEnvio(){
        System.out.println("Gestionando envío por avión.");

    }

    
}

class LogisticaDeTransporte  {
    public static void main(String[] args) {
        Logistica logisticaMaritima = new LogisticaMaritima();
        Transporte transporteMaritimo = logisticaMaritima.planificarEntrega();
        transporteMaritimo.gestionarEnvio();

        Logistica logisticaTerrestre = new LogisticaTerrestre();
        Transporte transporteTerrestre = logisticaTerrestre.planificarEntrega();
        transporteTerrestre.gestionarEnvio();

        Logistica logisticaAerea = new LogisticaAerea();
        Transporte transporteAereo = logisticaAerea.planificarEntrega();
        transporteAereo.gestionarEnvio();
    }
}
