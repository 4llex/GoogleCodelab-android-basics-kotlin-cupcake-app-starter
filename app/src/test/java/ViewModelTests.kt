import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.cupcake.model.OrderViewModel
import junit.framework.TestCase.assertEquals
import org.junit.Rule
import org.junit.Test
import java.util.*
import java.util.Locale.setDefault

class ViewModelTests {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @Test
    fun quantity_twelve_cupcakes() {
        val viewModel = OrderViewModel()
        viewModel.quantity.observeForever {}
        viewModel.setQuantity(12)
        assertEquals(12, viewModel.quantity.value)
    }

    @Test
    fun price_twelve_cupcakes_pt_adaptation() {
        val NBSP = "\u00A0"
        val viewModel = OrderViewModel()
        viewModel.price.observeForever {}
        viewModel.setQuantity(12)
        assertEquals("R$ 27,00", viewModel.price.value)
    }

    @Test
    fun price_twelve_cupcakes_us_loc() {
        setDefault(Locale.US)
        //setDefault(Locale.GERMANY)
        //setDefault(Locale.FRANCE)
        //setDefault(Locale.getDefault())

        // with a language code
        val locale = Locale("en-US")
        // with a language and country code
        val locale1 = Locale("en", "US")
        //Locale.setDefault(locale)

        val viewModel = OrderViewModel()
        viewModel.price.observeForever {}
        viewModel.setQuantity(12)
        assertEquals("$27.00", viewModel.price.value)
    }


}