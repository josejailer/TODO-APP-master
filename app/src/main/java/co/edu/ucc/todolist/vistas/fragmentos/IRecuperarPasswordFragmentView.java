package co.edu.ucc.todolist.vistas.fragmentos;

/**
 * Created by Jailer on 24/10/2017.
 */

public interface IRecuperarPasswordFragmentView {

    void mostrarProgress();
    void ocultarProgress();
    void habilitarVistas();
    void deshabilitarVistas();
    void mostrarError(String mensaje);
    void irALogin();
    void finalizarRecuperarPassword();
}
