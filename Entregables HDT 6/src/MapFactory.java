import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Patron de diseño Factory para la instancia del map
 */
public class MapFactory<K,V> {

    /**
     * Instancia del map usando el patron de diseño factory
     * @param option opcion de mapa seleccionada por el usuario
     * @return el map
     */
    public Map<K,V> createMap(int option){
        Map<K,V> map = null;
        switch (option){
            case 1:
                map = new HashMap<K,V>();
            case 2:
                map = new TreeMap<K,V>();
            case 3:
                map = new LinkedHashMap<K,V>();
        }
        return map;
    }
}
