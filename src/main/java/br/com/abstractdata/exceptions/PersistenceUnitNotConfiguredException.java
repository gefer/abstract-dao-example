package br.com.abstractdata.exceptions;

/**
 *
 * @author gefer
 */
public class PersistenceUnitNotConfiguredException extends RuntimeException {

    public PersistenceUnitNotConfiguredException() {
        super("O arquivo persistence.xml não foi configurado!");
    }

}
