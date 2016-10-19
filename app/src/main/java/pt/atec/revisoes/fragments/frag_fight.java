package pt.atec.revisoes.fragments;

import android.content.Context;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import pt.atec.revisoes.model.Arma;
import pt.atec.revisoes.model.Monstro;
import org.w3c.dom.Text;

import java.util.ArrayList;

import pt.atec.revisoes.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link frag_fight.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link frag_fight#newInstance} factory method to
 * create an instance of this fragment.
 */
public class frag_fight extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";
    ImageView mEnemy;
    TextView mHpenemy;
    RecyclerView mRecycler;

    Monstro mMonstro;

    public frag_fight(Monstro m)
    {
        this.mMonstro = m;
    }


    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public frag_fight() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static frag_fight newInstance(String param1, String param2) {
        frag_fight fragment = new frag_fight();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_frag_fight, container, false);
        //já criamos a view agora podemos definir o que são os objectos

        mEnemy = (ImageView) v.findViewById(R.id.fight_img);
        mHpenemy = (TextView) v.findViewById(R.id.fight_hp);
        mRecycler = (RecyclerView) v.findViewById(R.id.fight_recycler);

        mEnemy.setImageResource(mMonstro.getImage());
        mHpenemy.setText(String.valueOf(mMonstro.getHp()));

        mRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        Arma espada = new Arma(R.drawable.alien_sword, "Espada do conan", 20);
        Arma crossb = new Arma(R.drawable.crossbow, "Besta do conan", 40);
        Arma bow = new Arma(R.drawable.bow, "Arco do conan", 50);
        Arma staff = new Arma(R.drawable.yuna_staff, "Pau do conan", 70);

        ArrayList<Arma> armas = new ArrayList<Arma>();
        armas.add(espada);
        armas.add(crossb);
        armas.add(bow);
        armas.add(staff);


        AArmas aarmas = new AArmas(armas);
        mRecycler.setAdapter(aarmas);
//criamos uma view do fragmento

        return v;
    }


    public class AArmas extends Adapter<AArmas.VHarma> {

        ArrayList<Arma> mDataset;

        public AArmas(ArrayList<Arma> ar) {
            this.mDataset = ar;
        }

        @Override
        public VHarma onCreateViewHolder(ViewGroup parent, int viewType) {

            View v = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.card_arma, parent, false);
            return new VHarma(v);
        }

        @Override
        public void onBindViewHolder(VHarma holder, int position) {
            holder.setData(mDataset.get(position));
        }

        @Override
        public int getItemCount() {
            return mDataset.size();
        }

        public class VHarma extends ViewHolder {
            ImageView mImgarma;
            TextView mNomeArma;
            TextView mAtaque;

            public ImageView getmImgarma() {
                return mImgarma;
            }

            public void setmImgarma(ImageView mImgarma) {
                this.mImgarma = mImgarma;
            }

            public TextView getmNomeArma() {
                return mNomeArma;
            }

            public void setmNomeArma(TextView mNomeArma) {
                this.mNomeArma = mNomeArma;
            }

            public TextView getmAtaque() {
                return mAtaque;
            }

            public void setmAtaque(TextView mAtaque) {
                this.mAtaque = mAtaque;
            }

            public VHarma(final View itemView) {
                super(itemView);

                mImgarma = (ImageView) itemView.findViewById(R.id.card_img);
                mNomeArma = (TextView) itemView.findViewById(R.id.card_arma);
                mAtaque = (TextView) itemView.findViewById(R.id.card_attack);
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int newHp = Integer.valueOf(mHpenemy.getText().toString())-
                                Integer.valueOf(mAtaque.getText().toString());
                        mHpenemy.setText(String.valueOf(newHp));

                    }
                });

            }

            public void setData(Arma ar) {

                this.mImgarma.setImageResource(ar.getImagem());
                this.mNomeArma.setText(ar.getNome().toString());
                this.mAtaque.setText(String.valueOf(ar.getAttack()));
            }
        }

    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
