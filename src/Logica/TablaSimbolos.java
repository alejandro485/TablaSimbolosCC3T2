package Logica;

import java.util.HashMap;

public class TablaSimbolos {

	public HashMap<String, Estructura> lista;

	public TablaSimbolos() {
		lista = new HashMap<String, Estructura>();
	}

	public boolean buscarToken(String _t) {
		return lista.containsKey(_t);
	}

	public int agregarToken(String _n, String _t, String _v) {
		if((_t=="int" || _t=="float") && !verificarNumerico(_v)){
			return 1;// el valor inicial no es numerico
		}
		int  _l=0, _f=0;
		switch (_t){
			case "int":
				_l=8;
				_f=0;
			break;
			case "float":
				_l=16;
				_f=8;
			break;
			case "string":
				_l=20;
				_f=0;
			break;
			case "char":
				_l=8;
				_f=0;
			case "boolean":
				_l=1;
				_f=0;
			break;
			default:
				return 2; //Tipo de dato no encontrado
		}
		Estructura es=new Estructura(_t, _v, _l, _f);
		lista.put(_n, es);
		return 0; //topo integro
	}
	
	public void resetearLista(){
		lista.clear();
	}

	public boolean verificarNumerico(String _str) {
		try {
			double d = Double.parseDouble(_str);
		} catch (NumberFormatException nfe) {
			return false;
		}
		return true;
	}

}
