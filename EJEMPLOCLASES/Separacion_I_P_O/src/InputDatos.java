public class InputDatos {
        public double pesoKg;
        public int  distanciaKm;
        public int tipoServicio;
        public boolean ZonaRemota;  
        public int valorMinimo;
        public int ValorMaximo;
        
        public InputDatos (){}

        public void setPesoKg (double pesoKg){
            this.pesoKg=pesoKg;
        }
        public void setDistanciaKm (int distanciaKm){
            this.distanciaKm=distanciaKm;
        }
        public void setTipoServicio (int tipoServicio){
            this.tipoServicio=tipoServicio;
        }
        public void setZonaRemota (boolean ZonaRemota){
            this.ZonaRemota=ZonaRemota;
        }
        public void setValorMinimo (int valorMinimo){
            this.valorMinimo=valorMinimo;
        }
        public void setValorMaximo (int ValorMaximo){
            this.ValorMaximo=ValorMaximo;
        }
}
