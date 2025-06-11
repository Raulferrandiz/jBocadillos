package utils;

public class Validaciones {

    public static boolean esNum(String cadena) {

        if (cadena != null){
            for (int i = 0; i < cadena.length(); i++) {
                if (cadena.charAt(i) < '0' || cadena.charAt(i) > '9')
                    return false;
            }

            return true;
        } else if (cadena == null) {
            return false;
        }
        return false;
    }


    public static boolean valNombre(String nombre) {

        if (nombre != null){
            //Mínimo 3 carcteres
            if (nombre.length() < 3) {
                System.out.println("El nombre o apellido tiene que tener como mínimo 3 caracteres");
                return false;
            }

            nombre = nombre.toLowerCase();

            //Si tiene algun caracter que no este entre la a o z mayuscula o minuscula o alguno de los especiales especificados a algo devuelve error
            for (int i = 0; i < nombre.length(); i++) {
                if ((nombre.charAt(i) < 'a' || nombre.charAt(i) > 'z') && //ó
                        (nombre.charAt(i) != 'á'
                                && nombre.charAt(i) != 'é'
                                && nombre.charAt(i) != 'i'
                                && nombre.charAt(i) != 'ó'
                                && nombre.charAt(i) != 'ú'
                                && nombre.charAt(i) != 'ñ'
                        )) {
                    System.out.println("El nombre o apellido solo puede contener letras");
                    return false;
                }
            }

            return true;
        }
        return false;
    }

    /**
     * @param email
     * @return devuelve falso si no cumple alguna de las condiciones especificadas
     */
    public static boolean valEmail(String email) {

        int arro = email.indexOf('@');
        int punto = email.lastIndexOf('.');

        // Se asegura que el @ se situe despues de la primera posición para saber si hay texto delante de esta
        if (arro < 1) {
            System.out.println("El @ no puede situarse sin texto delante");
            return false;
        }

        // Se situa en el punto y despues se desplaza 2 carcteres mas del @ para comprobar que hay texto entre el @ y el .
        if (punto < arro + 2) {
            System.out.println("Tiene que haber texto entre el @ y el .");
            return false;
        }

        // Se asegura de que hay texto despues del punto
        if (punto == email.length() - 1) {
            System.out.println("Tiene que haber texto despues del punto");
            return false;
        }

        for (int i = 0; i < email.length(); i++) {
            char c = email.charAt(i);
            //Comprueba si todos los caracteres antes del @ son validos
            if (i < arro) {
                if (!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && !(c >= '0' && c <= '9') && c != '.') {
                    System.out.println("Solo se permiten letras y números");
                    return false;
                }
                //Después del punto solo pueden haber minusculas
            } else if (i > punto) {
                if (!(c >= 'a' && c <= 'z')) {
                    return false;
                }
                //Antes del punto y después del @ solo pueden haber minusculas
            } else if (i > arro && i < punto) {
                if (!(c >= 'a' && c <= 'z')) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * @param contra
     * @return valida que la contraseña tenga como mínimo 8 caracteres, una mayuscula, una minuscula, un número y un caracter especial
     */
    public static boolean valContra(String contra) {
        int condicion = 0;
        if (contra != null) {

            //Al menos una minúscula, rompe el bucle
            for (int i = 0; i < contra.length(); i++) {
                char letra = contra.charAt(i);

                if (letra >= 'a' && letra <= 'z') {
                    condicion++;
                    break;
                }
            }

            //Al menos una mayuscula, rompe el bucle
            for (int i = 0; i < contra.length(); i++) {
                char letra = contra.charAt(i);

                if (letra >= 'A' && letra <= 'Z') {
                    condicion++;
                    break;
                }
            }

            // Al menos un carácter especial, rompe el bucle
            for (int i = 0; i < contra.length(); i++) {
                char letra = contra.charAt(i);

                if (!(letra >= 'A' && letra <= 'Z') && !(letra >= 'a' && letra <= 'z') && !(letra >= '0' && letra <= '9')) {
                    condicion++;
                    break;
                }
            }

            //Al menos un número, rompe el bucle
            for (int i = 0; i < contra.length(); i++) {
                char letra = contra.charAt(i);

                if (letra >= '0' && letra <= '9') {
                    condicion++;
                    break;
                }
            }

            if (condicion == 4) {
                return true;
            }

            return false;
        }
        return false;
    }

        /**
         * @param dn
         * @return devuelve falso cuando el dni no tiene 9 caracteres de longitud, también devuelve falso si los primeros 8 caracteres no son numeros, y si el ultimo caracter no es una letra mayuscula
         */ /*
    public static boolean val_dni(String dn) {
        if (dn.length() != 9) {
            System.out.println("El DNI tiene que tener 9 caracteres de longitud");
            return false;
        }

        // Comprueba que los primeros 8 caracteres sean números caracter a caracter
        for (int i = 0; i < 8; i++) {
            char letra = dn.charAt(i);
            if (letra < '0' || letra > '9') { // Verifica si no está en el rango de caracteres '0' a '9'
                return false;
            }
        }

        //Comprueba la últiama letra
        char ultimaLetra = dn.charAt(8);
        if ((ultimaLetra < 'A' || ultimaLetra > 'Z')) {
            return false; // Verifica si no está en los rangos de caracteres 'A'-'Z'
        }
        return true;
    }

    /**
     * @param fecha
     * @return devuelve falso si no cumple alguna de las condiciones
     */ /*
    public static boolean val_fecha(String fecha) {
        Usuario.menor = false;
        if (fecha.length() != 10) {
            System.out.println("La fecha tiene que tener 10 caracteres de longitud");
            return false;
        }

        //Aqui comprueba que esten separados con / o guiones (me fallaba aqui porque me faltaba un parentesis)
        if (!((fecha.charAt(2) == '/' && (fecha.charAt(5) == '/')) || (fecha.charAt(2) == '-') && fecha.charAt(5) == '-')) {
            System.out.println("No has separado correctamente la fecha");
            return false;
        }

        //Todos los caracteres menos los separadores tienen que ser numeros
        for (int i = 0; i < fecha.length(); i++) {
            if (i != 2 && i != 5) { //Sepradadores
                char c = fecha.charAt(i);
                if (c < '0' || c > '9') {
                    System.out.println("Solo se permiten caracteres númericos para la fecha");
                    return false;
                }
            }
        }

        //divide la fecha en dia, mes y año
        String dia = fecha.substring(0, 2);
        String mes = fecha.substring(3, 5);
        String anyo = fecha.substring(6, 10);

        int nDia = Integer.parseInt(dia);
        int nMes = Integer.parseInt(mes);
        int nAnyo = Integer.parseInt(anyo);

        //El mes tiene que ser mayor que uno y menor que 12
        if (nMes < 1 || nMes > 12) {
            System.out.println("Mes introducido no valido");
            return false;
        }

        // Aqui verifica que el dia corresponda con el maximo de dias que hay en ese mes, en este caso tienen 31 dias
        if ((nMes == 1 || nMes == 3 || nMes == 5 || nMes == 7 || nMes == 8 || nMes == 10 || nMes == 12) && nDia > 31) {
            System.out.println("El mes " + nMes + " solo puede tener 31 dias");
            return false;
        }

        // Aqui verifica que el dia corresponda con el maximo de dias que hay en ese mes, en este caso tienen 30 dias
        if ((nMes == 4 || nMes == 6 || nMes == 9 || nMes == 11) && nDia > 30) {
            System.out.println("El mes " + nMes + " solo puede tener 30 dias");
            return false;
        }

        //Febrero
        if (nMes == 2) {
            if ((nAnyo % 4 == 0 && nAnyo % 100 != 0) || (nAnyo % 400 == 0)) {
                //Si el año es bisiesto febrero tiene 29 dias
                if (nDia > 29) {
                    System.out.println("Febrero solo puede tener 29 este año");
                    return false;
                }

            } else if (nDia > 28) {//Si el año no es bisiesto febrero tien 28 dias
                System.out.println("Febrero solo puede tener 28 dias este año");
                return false;
            }
        }

        //Solo se permiten años desde el 1900 hasta el 2006, Si es del 2006 tiene que ser de noviembre o menor que noviembre
        if (nAnyo < 1900 || nAnyo > 2006 || (nAnyo == 2006 && nMes > 11)) {
            Usuario.menor = true;
            System.out.println("Eres menor de edad");
            return false;
        }

        return true;
    }

        //Al menos una minúscula, rompe el bucle
        for (int i = 0; i < contra.length(); i++) {
            char letra = contra.charAt(i);

            if (letra >= 'a' && letra <= 'z') {
                condicion++;
                break;
            }
        }

        // Al menos un carácter especial, rompe el bucle
        for (int i = 0; i < contra.length(); i++) {
            char letra = contra.charAt(i);

            if (!(letra >= 'A' && letra <= 'Z') && !(letra >= 'a' && letra <= 'z') && !(letra >= '0' && letra <= '9')) {
                condicion++;
                break;
            }
        }

        //Al menos un número, rompe el bucle
        for (int i = 0; i < contra.length(); i++) {
            char letra = contra.charAt(i);

            if (letra >= '0' && letra <= '9') {
                condicion++;
                break;
            }
        }

        if (condicion == 4) {
            return true;
        }

        return false;
    }

    /**
     * @param color
     * @return true si solo contiene letras
     */ /*
    public static boolean val_color(String color) {
        //Valida que solo esten letras ya que no nos pide nada más relacionado con la pregunta de seguridad
        for (int i = 0; i < color.length(); i++) {
            if ((color.charAt(i) < 'a' || color.charAt(i) > 'z') && (color.charAt(i) < 'A' || color.charAt(i) > 'Z') &&
                    (color.charAt(i) != 'á'
                            || color.charAt(i) != 'é'
                            || color.charAt(i) != 'i'
                            || color.charAt(i) != 'ó'
                            || color.charAt(i) != 'ú'
                            || color.charAt(i) != 'ñ'
                    )) {
                System.out.println("El color solo puede contener letras.");
                return false;
            }
        }

        return true;
    }
    */

}
