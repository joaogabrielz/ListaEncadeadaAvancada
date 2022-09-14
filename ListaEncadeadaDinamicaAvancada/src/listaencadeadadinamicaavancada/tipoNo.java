package listaencadeadadinamicaavancada;


public class tipoNo{
    
	public String info;
        public int num;
        
	public tipoNo prox;
        public tipoNo anterior;
	
	public tipoNo(){}
        
        

        public int getNum() {
            return num;
        }

        public void setNum(int num) {
            this.num = num;
        }

        public tipoNo getAnterior() {
            return anterior;
        }

        public void setAnterior(tipoNo anterior) {
            this.anterior = anterior;
        }
      
	public void setInfo(String info){
		this.info=info;
	}

	public void setProx(tipoNo prox){
		this.prox=prox;
	}
	
	public String getInfo(){
		return info;
	}
	public tipoNo getProx(){
		return prox;
	}

	
}