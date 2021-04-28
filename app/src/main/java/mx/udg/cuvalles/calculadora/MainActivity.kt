package mx.udg.cuvalles.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity(), View.OnClickListener {

    //https://github.com/erickvalles/Calculadora21A
    var operacion = ""
    var operacionPendiente = false
    var existeResultado = false

    lateinit var btn1:Button
    lateinit var btn2:Button
    lateinit var btn3:Button
    lateinit var btn4:Button
    lateinit var btn9:Button
    lateinit var btnSum:Button
    lateinit var btnIgual:Button
    lateinit var btnResta:Button
    lateinit var etVisor:EditText



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()

    }

    private fun initUI(){
        btn1 = findViewById(R.id.btn1)
        btn2 = findViewById(R.id.btn2)
        btn3 = findViewById(R.id.btn3)
        btn4 = findViewById(R.id.btn4)
        btn9 = findViewById(R.id.btn9)
        btnSum = findViewById(R.id.btnSum)
        btnResta = findViewById(R.id.btnRes)
        btnIgual = findViewById(R.id.btnIgual)
        etVisor = findViewById(R.id.etVisor)
        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn9.setOnClickListener(this)
        btnIgual.setOnClickListener(this)
        btnSum.setOnClickListener(this)
        btnResta.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.btn1->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append(getString(R.string.uno))
            }
            R.id.btn2->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("2")
            }
            R.id.btn3->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("3")
            }
            R.id.btn4->{
                if (existeResultado)
                    limpiarPantalla()
                etVisor.append("4")
            }
            R.id.btn9->{
                limpiarPantalla()
            }
            R.id.btnSum->{

                if (!operacionPendiente){
                    operacion = "suma"
                    etVisor.append("+")
                    operacionPendiente = true
                }
            }
            R.id.btnRes->{

                if (!operacionPendiente){
                    operacion = "resta"
                    etVisor.append("-")
                    operacionPendiente = true
                }
            }
            R.id.btnIgual->{
                if (operacionPendiente){
                    val textoOperacion = etVisor.text.toString()
                    var delimitador = ""
                    when(operacion){
                        "suma"->delimitador="+"
                        "resta"->delimitador="-"
                    }

                    val operandos = textoOperacion.split(delimitador)
                    val operando1 = operandos[0].toDouble()
                    val operando2 = operandos[1].toDouble()
                    var resultado = 0.0
                    when (operacion){
                        "suma"->{
                            resultado = operando1+operando2
                        }
                        "resta"->{
                            resultado = operando1-operando2
                        }


                    }
                    etVisor.setText("${resultado}")
                    existeResultado = true

                }
            }
        }
    }

    fun limpiarPantalla(){
        etVisor.setText("")
        operacionPendiente=false
        existeResultado = false
    }
}