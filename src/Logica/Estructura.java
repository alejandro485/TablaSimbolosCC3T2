package Logica;

public class Estructura {

	public String tipo;
	public String valorInicial;
	public int longitud;
	public int flotante;
	
	public Estructura(String _t, String _v, int _l, int _f) {
		flotante = _f;
		tipo = _t;
		valorInicial = _v;
		longitud = _l;
	}
	
	public String getTamano(){
		if(flotante==0){
			return longitud+"";
		}
		return "("+longitud+","+flotante+")";
	}
	
}
