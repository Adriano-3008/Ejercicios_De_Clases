/*
@startuml

interface FabricaComputadora{
CrearProcesador():Procesador
CrearGrafica():Grafica
CrearDisco():Disco
CrearRAM():Ram
CrearOS():SistemaOperativo
}

class FabricaComputadoraUSA{
+CrearProcesador():Procesador
+CrearGrafica():Grafica
+CrearDisco():Disco
+CrearRAM():Ram
+CrearOS():SistemaOperativo
}
   
class FabricaComputadoraJapon{
+CrearProcesador():Procesador
+CrearGrafica():Grafica
+CrearDisco():Disco
+CrearRAM():Ram
+CrearOS():SistemaOperativo
}



abstract class Computadora{
-Nombre:String
-Procesador:Procesador
-grafica:Grafica
-discoDuro:Disco
-RAM:Ram
-OS:Sistemaoperativo
+ensamblar():void
+probar():void
+embalar():void
}

abstract class Ensambladora{
crearComputadora(Tipo:String):Computadora
ordenarComputador(Tipo:String):Computadora
}

class EnsambladoraUSA{
+crearComputadora(Tipo:String):Computadora
}

class EnsambladoraJapon{
+crearComputadora(Tipo:String):Computadora
}


interface Grafica{
toString(): void
}

interface Disco {
toString(): void
}

interface Ram{
toString(): void
}

interface SistemaOperativo {
toString(): void
}

interface Procesador{
toString(): void
}

class ComputadoraGamer{
+ensamblar():void
+probar():void
+embalar():void
}

class ComputadoraOficina{
+ensamblar():void
+probar():void
+embalar():void
}

class Intel{
toString():void
}
class AMD{
toString():void
}
Procesador <|.. Intel
Procesador <|.. AMD


class NvidiaRTX{
toString():void
}
class RadeonRX{
toString():void
}
Grafica <|.. NvidiaRTX
Grafica <|.. RadeonRX


class SSD1TB{
toString():void
}
class HDD2TB{
toString():void
}
Disco <|..HDD2TB
Disco <|..SSD1TB


class RAM16GB{
toString():void
}
class RAM32GB{
toString():void
}
Ram <|..RAM16GB
Ram <|..RAM32GB


class Windows11{
toString():void
}
class UbuntuLinux{
toString():void
}
SistemaOperativo <|.. Windows11
SistemaOperativo <|.. UbuntuLinux


FabricaComputadora <|.. FabricaComputadoraUSA
FabricaComputadora <|.. FabricaComputadoraJapon
FabricaComputadora *-- Procesador
FabricaComputadora *-- Grafica
FabricaComputadora *-- Disco
FabricaComputadora *-- Ram
FabricaComputadora *-- SistemaOperativo
Computadora o-- FabricaComputadora
Computadora <|-- ComputadoraGamer
Computadora <|-- ComputadoraOficina
Ensambladora <|-- EnsambladoraUSA
Ensambladora <|-- EnsambladoraJapon
Ensambladora o-- Computadora

@enduml 

 */

public class FabricaComputadoraAbstractFactory {
    public static void main(String[] args) {
        // Ejemplo 1: Computadora Gamer en USA
        FabricaComputadora fabricaUSA = new FabricaComputadoraUSA();
        Computadora gamerUSA = new ComputadoraGamer(fabricaUSA);
        gamerUSA.ensamblar();
        gamerUSA.probar();
        gamerUSA.embalar();

        // Ejemplo 2: Computadora de Oficina en USA
        Computadora oficinaUSA = new ComputadoraOficina(fabricaUSA);
        oficinaUSA.ensamblar();
        oficinaUSA.probar();
        oficinaUSA.embalar();

        // Ejemplo 3: Computadora Gamer en Japón
        FabricaComputadora fabricaJapon = new FabricaComputadoraJapon();
        Computadora gamerJapon = new ComputadoraGamer(fabricaJapon);
        gamerJapon.ensamblar();
        gamerJapon.probar();
        gamerJapon.embalar();

        // Ejemplo 4: Computadora de Oficina en Japón
        Computadora oficinaJapon = new ComputadoraOficina(fabricaJapon);
        oficinaJapon.ensamblar();
        oficinaJapon.probar();
        oficinaJapon.embalar();
    }
}



interface FabricaComputadora {
    Procesador crearProcesador();
    Grafica crearGrafica();
    Disco crearDisco();
    Ram crearRAM();
    SistemaOperativo crearOS();
}

// Implementaciones de FabricaComputadora
class FabricaComputadoraUSA implements FabricaComputadora {
    public Procesador crearProcesador() {
        return new Intel();
    }

    public Grafica crearGrafica() {
        return new NvidiaRTX();
    }

    public Disco crearDisco() {
        return new SSD1TB();
    }

    public Ram crearRAM() {
        return new RAM16GB();
    }

    public SistemaOperativo crearOS() {
        return new Windows11();
    }
}

class FabricaComputadoraJapon implements FabricaComputadora {
    public Procesador crearProcesador() {
        return new AMD();
    }

    public Grafica crearGrafica() {
        return new RadeonRX();
    }

    public Disco crearDisco() {
        return new HDD2TB();
    }

    public Ram crearRAM() {
        return new RAM32GB();
    }

    public SistemaOperativo crearOS() {
        return new UbuntuLinux();
    }
}

// Clases abstractas y concretas de Computadora
abstract class Computadora {
    String nombre;
    Procesador procesador;
    Grafica grafica;
    Disco discoDuro;
    Ram ram;
    SistemaOperativo os;

    abstract void ensamblar();

    void probar() {
        System.out.println("Probando la computadora " + nombre);
    }

    void embalar() {
        System.out.println("Embalando la computadora " + nombre);
    }
}

class ComputadoraGamer extends Computadora {
    public ComputadoraGamer(FabricaComputadora fabrica) {
        nombre = "Computadora Gamer";
        procesador = fabrica.crearProcesador();
        grafica = fabrica.crearGrafica();
        discoDuro = fabrica.crearDisco();
        ram = fabrica.crearRAM();
        os = fabrica.crearOS();
    }

    @Override
    void ensamblar() {
        System.out.println("Ensamblando " + nombre);
    }
}

class ComputadoraOficina extends Computadora {
    public ComputadoraOficina(FabricaComputadora fabrica) {
        nombre = "Computadora de Oficina";
        procesador = fabrica.crearProcesador();
        grafica = fabrica.crearGrafica();
        discoDuro = fabrica.crearDisco();
        ram = fabrica.crearRAM();
        os = fabrica.crearOS();
    }

    @Override
    void ensamblar() {
        System.out.println("Ensamblando " + nombre);
    }
}

// Interfaces de componentes
interface Procesador {
    String toString();
}

interface Grafica {
    String toString();
}

interface Disco {
    String toString();
}

interface Ram {
    String toString();
}

interface SistemaOperativo {
    String toString();
}

// Implementaciones de componentes
class Intel implements Procesador {
    public String toString() {
        return "Procesador Intel";
    }
}

class AMD implements Procesador {
    public String toString() {
        return "Procesador AMD";
    }
}

class NvidiaRTX implements Grafica {
    public String toString() {
        return "Gráfica Nvidia RTX";
    }
}

class RadeonRX implements Grafica {
    public String toString() {
        return "Gráfica Radeon RX";
    }
}

class SSD1TB implements Disco {
    public String toString() {
        return "Disco SSD 1TB";
    }
}

class HDD2TB implements Disco {
    public String toString() {
        return "Disco HDD 2TB";
    }
}

class RAM16GB implements Ram {
    public String toString() {
        return "RAM 16GB";
    }
}

class RAM32GB implements Ram {
    public String toString() {
        return "RAM 32GB";
    }
}

class Windows11 implements SistemaOperativo {
    public String toString() {
        return "Windows 11";
    }
}

class UbuntuLinux implements SistemaOperativo {
    public String toString() {
        return "Ubuntu Linux";
    }
}
