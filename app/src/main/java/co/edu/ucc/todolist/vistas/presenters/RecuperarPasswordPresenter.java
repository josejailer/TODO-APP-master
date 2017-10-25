package co.edu.ucc.todolist.vistas.presenters;

import co.edu.ucc.todolist.dominio.CallBackInteractor;
import co.edu.ucc.todolist.dominio.ILUsuario;
import co.edu.ucc.todolist.dominio.LUsuario;
import co.edu.ucc.todolist.vistas.fragmentos.IRecuperarPasswordFragmentView;

/**
 * Created by Jailer on 24/10/2017.
 */

public class RecuperarPasswordPresenter implements IRecuperarPasswordPresenter {

    private IRecuperarPasswordFragmentView view;
    private ILUsuario lUsuario;

     public RecuperarPasswordPresenter(IRecuperarPasswordFragmentView view) {
        this.view = view;
        lUsuario = new LUsuario();
    }

    @Override
    public void recuperarPassword(String email) {
        view.deshabilitarVistas();
        view.mostrarProgress();

        try {
        lUsuario.recuperarPassword(email,new CallBackInteractor<Boolean>() {
        @Override
        public void success(Boolean data) {

            view.ocultarProgress();
            view.habilitarVistas();
            view.finalizarRecuperarPassword();

        }

        @Override
        public void error(String error) {

        view.mostrarError(error);
            view.ocultarProgress();
            view.habilitarVistas();
        }
    });
        } catch (Exception e) {
            view.ocultarProgress();
            view.mostrarError(e.getMessage());
            view.habilitarVistas();
        }
    }
}
