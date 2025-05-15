/*
@startuml
    class Motor {
        + encender(): boolean
        + apagar(): boolean
    }

    class Neumaticos {
        + verificarPresion(): boolean
    }

    class Combustible {
        + verificarNivel(): boolean
    }

    class Asiento {
        + ajustarPosicion(): boolean
    }

    class Navegador {
        + configurarRuta(destino: String): String
    }

    class SistemaAudio {
        + reproducirPlaylist(): boolean
    }

    class InicioViajeFacade {
        + prepararViaje(destino: String): void
        + terminarViaje(): boolean
        - motor: Motor
        - neumaticos: Neumaticos
        - combustible: Combustible
        - asiento: Asiento
        - navegador: Navegador
        - sistemaAudio: SistemaAudio
    }

  InicioViajeFacade *-- Asiento
  InicioViajeFacade *-- Motor
  InicioViajeFacade *-- Neumaticos
  InicioViajeFacade *-- Combustible
  InicioViajeFacade *-- Navegador
  InicioViajeFacade *-- SistemaAudio
    



@enduml
 */

class Motor {
    public boolean encender() {
        System.out.println("Motor encendido.");
        return true;
    }

    public boolean apagar() {
        System.out.println("Motor apagado.");
        return true;
    }
}


class Neumaticos {
    public boolean verificarPresion() {
        System.out.println("Presión de los neumáticos verificada.");
        return true;
    }
}


class Combustible {
    public boolean verificarNivel() {
        System.out.println("Nivel de combustible verificado.");
        return true;
    }
}


class Asiento {
    public boolean ajustarPosicion() {
        System.out.println("Posición del asiento ajustada.");
        return true;
    }
}


class Navegador {
    public String configurarRuta(String destino) {
        System.out.println("Ruta configurada hacia: " + destino);
        return destino;
    }
}


class SistemaAudio {
    public boolean reproducirPlaylist() {
        System.out.println("Reproduciendo playlist.");
        return true;
    }
}

class InicioViajeFacade {
    private Motor motor;
    private Neumaticos neumaticos;
    private Combustible combustible;
    private Asiento asiento;
    private Navegador navegador;
    private SistemaAudio sistemaAudio;

    public InicioViajeFacade() {
        this.motor = new Motor();
        this.neumaticos = new Neumaticos();
        this.combustible = new Combustible();
        this.asiento = new Asiento();
        this.navegador = new Navegador();
        this.sistemaAudio = new SistemaAudio();
    }

    public void prepararViaje(String destino) {
        System.out.println("Preparando el viaje...");
        if (combustible.verificarNivel() && neumaticos.verificarPresion() && asiento.ajustarPosicion()) {
            navegador.configurarRuta(destino);
            sistemaAudio.reproducirPlaylist();
            motor.encender();
            System.out.println("¡Viaje preparado con éxito!");
        } else {
            System.out.println("No se pudo preparar el viaje.");
        }
    }

    public boolean terminarViaje() {
        System.out.println("Terminando el viaje...");
        return motor.apagar();
    }
}


public class SistemaDeArranqueAutomatico {
    public static void main(String[] args) {
        InicioViajeFacade inicioViaje = new InicioViajeFacade();
        inicioViaje.prepararViaje("Oficina");
        inicioViaje.terminarViaje();
    }
}