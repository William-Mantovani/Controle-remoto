package aula06_encaps;

public class ControleRemoto implements InterfaceControlador{
         //atributos
          private int volume;
          private boolean ligado;
          private boolean tocando; // se esta com som
          //metodos especiais
          public ControleRemoto() { //metodo cosntrutor
                    this.volume = 50;
                    this.ligado = false;
                    this.tocando = false;
          }
          //serão colocado em private pq somente a classe tem o poder de modificar esses metodos
          private int getVolume() {
                    return volume;
          }
          private void setVolume(int volume){
                    this.volume = volume;
          }
          
          private boolean getLigado() {
                    return ligado;
          }
          private void setLigado(boolean ligado){
                    this.ligado = ligado;
          }
          
          private boolean getTocando(){
                    return tocando;
          }
          private void setTocando(boolean tocando){
                    this.tocando = tocando;
          }

          @Override   // overrride significa sobrescrever
          public void ligar() {
                    this.setLigado(true);
          }

          @Override
          public void desligar() {
                    this.setLigado(false);
          }

          @Override
          public void abrirmenu() {
                    if(this.getLigado()){
                              System.out.println("-------MENU-------");
                              System.out.println("Está ligado? "+this.getLigado());
                              System.out.println("Está tocando? "+this.getTocando());
                              System.out.print("Volume: "+this.getVolume());
                              for (int i = 0; i <= this.getVolume(); i+=10){ // inicia em 0, se i for menor ou igual a 0 então i + 10?
                              System.out.print(" |");  
                                        }//fim for
                              }//fim if
                    else {
                            System.out.println("ligue o controle burro");
                              }//fim else
                    System.out.println("");
          }//fim metodo AbrirMenu

          @Override
          public void fecharMenu() {
                    System.out.println("Fechar Menu");
          }

          @Override
          public void maisVolume() {
                    if (this.getLigado()){
                              this.setVolume(this.getVolume() + 5);
                    }
          }

          @Override
          public void menosvolume() {
                    if(this.getLigado()) {
                              this.setVolume(this.getVolume() - 5);
                    }
          }

          @Override
          public void ligarMudo() {
                    if(this.getLigado() && this.getVolume() > 0){ //se estiver com som
                              this.setVolume(0);
                    }else {
                              System.out.println("impossivel tecla, ligue o controle");
                    }
          }

          @Override
          public void desligarMudo() {
                    if(this.getLigado() && this.getVolume() == 0 ){ //se estiver mudo 
                              this.setVolume(50);
                    }
          }

          @Override
          public void play() { //se estiver com pause
                    if(this.getLigado() && ! (this.getTocando())){
                              this.setTocando(true);
                    }
          }

          @Override
          public void pause() {
                    if(this.getLigado() && this.getTocando()){
                              this.setTocando(false);
                    }
          }
}
