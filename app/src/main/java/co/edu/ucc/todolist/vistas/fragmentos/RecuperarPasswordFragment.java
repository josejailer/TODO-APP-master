package co.edu.ucc.todolist.vistas.fragmentos;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import co.edu.ucc.todolist.R;
import co.edu.ucc.todolist.vistas.presenters.IRecuperarPasswordPresenter;
import co.edu.ucc.todolist.vistas.presenters.RecuperarPasswordPresenter;


public class RecuperarPasswordFragment extends Fragment implements IRecuperarPasswordFragmentView {
    @BindView(R.id.txtEmailRecuperar)
    EditText txtEmailRecuperar;

    @BindView(R.id.progress)
    ProgressBar progress;

    @BindView(R.id.btnRecuperarPass)
    Button btnRecuperarPass;


    private IRecuperarPasswordPresenter RecuperarPasswordPresenter;


    private OnFragmentInteractionListener mListener;

    public RecuperarPasswordFragment() {

    }

    public static RecuperarPasswordFragment newInstance() {
        RecuperarPasswordFragment fragment = new RecuperarPasswordFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recuperar_password, container, false);
        ButterKnife.bind(this, view);

        RecuperarPasswordPresenter= new RecuperarPasswordPresenter(this) ;

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @OnClick(R.id.btnRecuperarPass)
    public void recuperarPassword() {

        String email = txtEmailRecuperar.getText().toString();

        RecuperarPasswordPresenter.recuperarPassword(email);
    }

    @Override
    public void mostrarProgress() {
        progress.setVisibility(View.VISIBLE);

    }

    @Override
    public void ocultarProgress() {
        progress.setVisibility(View.GONE);

    }

    @Override
    public void habilitarVistas() {
        txtEmailRecuperar.setEnabled(true);
        btnRecuperarPass.setEnabled(true);

    }

    @Override
    public void deshabilitarVistas() {
        txtEmailRecuperar.setEnabled(false);
        btnRecuperarPass.setEnabled(false);

    }


    @Override
    public void mostrarError(String mensaje) {
        Snackbar.make(getView(), mensaje, Snackbar.LENGTH_LONG).show();

    }
    @OnClick(R.id.txtIrAlogin)
    @Override
    public void irALogin() {
        if (mListener != null) {
            mListener.irALogin();
        }
    }

   @Override
    public void finalizarRecuperarPassword() {
       Snackbar.make(getView(), "Revise el Mensaje en su Email", Snackbar.LENGTH_LONG).show();
       if (mListener != null) {
            mListener.finalizarRecuperarPassword();
        }
    }

    public interface OnFragmentInteractionListener {

        void irALogin();

       void finalizarRecuperarPassword();
    }
}
