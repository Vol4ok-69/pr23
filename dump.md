# Project Structure

```text
pr23
├── .kotlin
│   └── sessions
├── app
│   ├── src
│   │   ├── androidTest
│   │   │   └── java
│   │   │       └── com
│   │   │           └── example
│   │   │               └── pr23
│   │   │                   └── ExampleInstrumentedTest.kt
│   │   ├── main
│   │   │   ├── java
│   │   │   │   └── com
│   │   │   │       └── example
│   │   │   │           └── pr23
│   │   │   │               ├── data
│   │   │   │               │   └── MockRepository.kt
│   │   │   │               ├── model
│   │   │   │               │   ├── DeliveryState.kt
│   │   │   │               │   ├── PaymentMethod.kt
│   │   │   │               │   └── RoutePoint.kt
│   │   │   │               ├── ui
│   │   │   │               │   ├── delivery
│   │   │   │               │   │   └── DeliveryFragment.kt
│   │   │   │               │   ├── payment
│   │   │   │               │   │   └── AddPaymentFragment.kt
│   │   │   │               │   ├── tracking
│   │   │   │               │   │   └── TrackingFragment.kt
│   │   │   │               │   └── wallet
│   │   │   │               │       └── WalletFragment.kt
│   │   │   │               ├── utils
│   │   │   │               │   └── FragmentExtensions.kt
│   │   │   │               ├── viewmodel
│   │   │   │               │   └── SharedViewModel.kt
│   │   │   │               └── MainActivity.kt
│   │   │   ├── res
│   │   │   │   ├── color
│   │   │   │   │   └── bottom_nav_item_color.xml
│   │   │   │   ├── drawable
│   │   │   │   │   ├── ic_app_logo.xml
│   │   │   │   │   ├── ic_launcher_background.xml
│   │   │   │   │   ├── ic_launcher_foreground.xml
│   │   │   │   │   ├── ic_payment.xml
│   │   │   │   │   ├── ic_success.xml
│   │   │   │   │   ├── ic_tracking.xml
│   │   │   │   │   └── ic_wallet.xml
│   │   │   │   ├── layout
│   │   │   │   │   ├── activity_main.xml
│   │   │   │   │   ├── fragment_add_payment.xml
│   │   │   │   │   ├── fragment_delivery.xml
│   │   │   │   │   ├── fragment_tracking.xml
│   │   │   │   │   └── fragment_wallet.xml
│   │   │   │   ├── menu
│   │   │   │   │   └── bottom_nav_menu.xml
│   │   │   │   ├── mipmap-hdpi
│   │   │   │   │   ├── ic_launcher_round.webp
│   │   │   │   │   └── ic_launcher.webp
│   │   │   │   ├── mipmap-mdpi
│   │   │   │   │   ├── ic_launcher_round.webp
│   │   │   │   │   └── ic_launcher.webp
│   │   │   │   ├── mipmap-xhdpi
│   │   │   │   │   ├── ic_launcher_round.webp
│   │   │   │   │   └── ic_launcher.webp
│   │   │   │   ├── mipmap-xxhdpi
│   │   │   │   │   ├── ic_launcher_round.webp
│   │   │   │   │   └── ic_launcher.webp
│   │   │   │   ├── mipmap-xxxhdpi
│   │   │   │   │   ├── ic_launcher_round.webp
│   │   │   │   │   └── ic_launcher.webp
│   │   │   │   ├── navigation
│   │   │   │   │   └── nav_graph.xml
│   │   │   │   ├── values
│   │   │   │   │   ├── colors.xml
│   │   │   │   │   ├── strings.xml
│   │   │   │   │   ├── styles.xml
│   │   │   │   │   └── themes.xml
│   │   │   │   └── xml
│   │   │   │       ├── backup_rules.xml
│   │   │   │       └── data_extraction_rules.xml
│   │   │   └── AndroidManifest.xml
│   │   └── test
│   │       └── java
│   │           └── com
│   │               └── example
│   │                   └── pr23
│   │                       └── ExampleUnitTest.kt
│   ├── .gitignore
│   ├── build.gradle.kts
│   └── proguard-rules.pro
├── gradle
│   ├── wrapper
│   │   ├── gradle-wrapper.jar
│   │   └── gradle-wrapper.properties
│   ├── gradle-daemon-jvm.properties
│   └── libs.versions.toml
├── .gitignore
├── ПЗ.23 Создание структуры проекта в соответствии с паттерном.docx
├── build.gradle.kts
├── gradle.properties
├── gradlew
├── gradlew.bat
└── settings.gradle.kts

```


# File Contents

## app\src\androidTest\java\com\example\pr23\ExampleInstrumentedTest.kt

```kotlin
package com.example.pr23

import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.ext.junit.runners.AndroidJUnit4

import org.junit.Test
import org.junit.runner.RunWith

import org.junit.Assert.*

/**
 * Instrumented test, which will execute on an Android device.
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(AndroidJUnit4::class)
class ExampleInstrumentedTest {
    @Test
    fun useAppContext() {
        // Context of the app under test.
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("com.example.pr23", appContext.packageName)
    }
}
```

## app\src\main\java\com\example\pr23\data\MockRepository.kt

```kotlin
package com.example.pr23.data

import com.example.pr23.model.PaymentMethod
import com.example.pr23.model.RoutePoint

class MockRepository {

    fun getPaymentMethods(): List<PaymentMethod> = listOf(
        PaymentMethod(
            id = PAYMENT_CARD,
            title = "Банковская карта",
            description = "Visa, MasterCard или Мир"
        ),
        PaymentMethod(
            id = PAYMENT_CASH,
            title = "Наличные",
            description = "Оплата курьеру при получении"
        ),
        PaymentMethod(
            id = PAYMENT_WALLET,
            title = "Delivery Wallet",
            description = "Оплата с баланса кошелька"
        )
    )

    fun getRoutePoints(): List<RoutePoint> = listOf(
        RoutePoint(55.030204, 82.920430, "Склад"),
        RoutePoint(55.035600, 82.934900, "Сортировочный центр"),
        RoutePoint(55.041500, 82.948300, "Курьер в пути"),
        RoutePoint(55.050100, 82.966700, "Адрес доставки")
    )

    companion object {
        const val PAYMENT_CARD = "card"
        const val PAYMENT_CASH = "cash"
        const val PAYMENT_WALLET = "wallet"
    }
}

```

## app\src\main\java\com\example\pr23\model\DeliveryState.kt

```kotlin
package com.example.pr23.model

data class DeliveryState(
    val progress: Int,
    val statusText: String,
    val isCompleted: Boolean
)

```

## app\src\main\java\com\example\pr23\model\PaymentMethod.kt

```kotlin
package com.example.pr23.model

data class PaymentMethod(
    val id: String,
    val title: String,
    val description: String
)

```

## app\src\main\java\com\example\pr23\model\RoutePoint.kt

```kotlin
package com.example.pr23.model

data class RoutePoint(
    val latitude: Double,
    val longitude: Double,
    val title: String
)

```

## app\src\main\java\com\example\pr23\ui\delivery\DeliveryFragment.kt

```kotlin
package com.example.pr23.ui.delivery

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pr23.R
import com.example.pr23.databinding.FragmentDeliveryBinding
import com.example.pr23.utils.collectWhenStarted
import com.example.pr23.viewmodel.SharedViewModel

class DeliveryFragment : Fragment() {

    private var _binding: FragmentDeliveryBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedViewModel by lazy {
        ViewModelProvider(requireActivity())[SharedViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDeliveryBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.restartProgressButton.setOnClickListener {
            viewModel.restartDeliveryProgress()
        }

        viewModel.startDeliveryProgress()

        collectWhenStarted {
            viewModel.deliveryState.collect { state ->
                binding.deliveryProgressBar.progress = state.progress
                binding.progressValueText.text = getString(
                    R.string.delivery_progress_format,
                    state.progress
                )
                binding.deliveryStatusText.text = state.statusText
                binding.successTitleText.text = if (state.isCompleted) {
                    getString(R.string.delivery_success_title)
                } else {
                    getString(R.string.delivery_in_progress_title)
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

```

## app\src\main\java\com\example\pr23\ui\payment\AddPaymentFragment.kt

```kotlin
package com.example.pr23.ui.payment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pr23.R
import com.example.pr23.databinding.FragmentAddPaymentBinding
import com.example.pr23.model.PaymentMethod
import com.example.pr23.utils.collectWhenStarted
import com.example.pr23.viewmodel.SharedViewModel
import kotlinx.coroutines.launch

class AddPaymentFragment : Fragment() {

    private var _binding: FragmentAddPaymentBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedViewModel by lazy {
        ViewModelProvider(requireActivity())[SharedViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAddPaymentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.paymentRadioGroup.setOnCheckedChangeListener { _, checkedId ->
            when (checkedId) {
                R.id.cardRadioButton -> viewModel.selectPaymentMethod("card")
                R.id.cashRadioButton -> viewModel.selectPaymentMethod("cash")
                R.id.walletRadioButton -> viewModel.selectPaymentMethod("wallet")
            }
        }

        binding.backToWalletButton.setOnClickListener {
            val navController = findNavController()
            val returnedByBackStack = navController.popBackStack(R.id.walletFragment, false)
            if (!returnedByBackStack) {
                navController.navigate(R.id.walletFragment)
            }
        }

        collectWhenStarted {
            launch {
                viewModel.paymentMethods.collect { methods ->
                    renderDescriptions(methods)
                }
            }
            launch {
                viewModel.selectedPaymentMethod.collect { method ->
                    checkSelectedMethod(method.id)
                    binding.selectedPaymentText.text = getString(
                        R.string.selected_payment_format,
                        method.title
                    )
                }
            }
        }
    }

    private fun renderDescriptions(methods: List<PaymentMethod>) {
        val methodsById = methods.associateBy { it.id }
        binding.cardDescriptionText.text = methodsById["card"]?.description.orEmpty()
        binding.cashDescriptionText.text = methodsById["cash"]?.description.orEmpty()
        binding.walletDescriptionText.text = methodsById["wallet"]?.description.orEmpty()
    }

    private fun checkSelectedMethod(methodId: String) {
        val button: RadioButton = when (methodId) {
            "cash" -> binding.cashRadioButton
            "wallet" -> binding.walletRadioButton
            else -> binding.cardRadioButton
        }
        if (!button.isChecked) {
            button.isChecked = true
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

```

## app\src\main\java\com\example\pr23\ui\tracking\TrackingFragment.kt

```kotlin
package com.example.pr23.ui.tracking

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.pr23.R
import com.example.pr23.databinding.FragmentTrackingBinding
import com.example.pr23.model.RoutePoint
import com.example.pr23.utils.collectWhenStarted
import com.example.pr23.viewmodel.SharedViewModel
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.LatLngBounds
import com.google.android.gms.maps.model.MarkerOptions
import com.google.android.gms.maps.model.PolylineOptions
import kotlinx.coroutines.launch

class TrackingFragment : Fragment() {

    private var _binding: FragmentTrackingBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedViewModel by lazy {
        ViewModelProvider(requireActivity())[SharedViewModel::class.java]
    }
    private var googleMap: GoogleMap? = null
    private var lastRoutePoints: List<RoutePoint> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTrackingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val mapFragment = childFragmentManager
            .findFragmentById(R.id.mapFragment) as SupportMapFragment

        mapFragment.getMapAsync { map ->
            googleMap = map
            map.uiSettings.isZoomControlsEnabled = true
            map.uiSettings.isMapToolbarEnabled = true
            renderRoute(lastRoutePoints)
        }

        collectWhenStarted {
            launch {
                viewModel.routePoints.collect { points ->
                    lastRoutePoints = points
                    renderRoute(points)
                }
            }
        }
    }

    private fun renderRoute(points: List<RoutePoint>) {
        val map = googleMap ?: return
        if (points.isEmpty()) return

        map.clear()

        val routeCoordinates = points.map { LatLng(it.latitude, it.longitude) }
        points.forEach { point ->
            map.addMarker(
                MarkerOptions()
                    .position(LatLng(point.latitude, point.longitude))
                    .title(point.title)
            )
        }

        val routeColor = ContextCompat.getColor(requireContext(), R.color.delivery_green)
        map.addPolyline(
            PolylineOptions()
                .addAll(routeCoordinates)
                .color(routeColor)
                .width(10f)
                .geodesic(true)
        )

        val boundsBuilder = LatLngBounds.Builder()
        routeCoordinates.forEach { boundsBuilder.include(it) }
        map.animateCamera(CameraUpdateFactory.newLatLngBounds(boundsBuilder.build(), 96))

        binding.routeSummaryText.text = getString(
            R.string.route_summary_format,
            points.first().title,
            points.last().title
        )
    }

    override fun onDestroyView() {
        googleMap = null
        super.onDestroyView()
        _binding = null
    }
}

```

## app\src\main\java\com\example\pr23\ui\wallet\WalletFragment.kt

```kotlin
package com.example.pr23.ui.wallet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.example.pr23.R
import com.example.pr23.databinding.FragmentWalletBinding
import com.example.pr23.utils.collectWhenStarted
import com.example.pr23.viewmodel.SharedViewModel
import kotlinx.coroutines.launch

class WalletFragment : Fragment() {

    private var _binding: FragmentWalletBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SharedViewModel by lazy {
        ViewModelProvider(requireActivity())[SharedViewModel::class.java]
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWalletBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.addPaymentButton.setOnClickListener {
            findNavController().navigate(R.id.addPaymentFragment)
        }
        binding.trackPackageButton.setOnClickListener {
            findNavController().navigate(R.id.trackingFragment)
        }
        binding.deliveryStatusButton.setOnClickListener {
            findNavController().navigate(R.id.deliveryFragment)
        }

        collectWhenStarted {
            launch {
                viewModel.selectedPaymentMethod.collect { method ->
                    binding.paymentMethodText.text = method.title
                    binding.paymentDescriptionText.text = method.description
                }
            }
            launch {
                viewModel.deliveryState.collect { state ->
                    binding.deliveryProgressText.text = "${state.progress}%"
                    binding.deliveryStatusText.text = state.statusText
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}

```

## app\src\main\java\com\example\pr23\utils\FragmentExtensions.kt

```kotlin
package com.example.pr23.utils

import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

fun Fragment.collectWhenStarted(block: suspend CoroutineScope.() -> Unit) {
    viewLifecycleOwner.lifecycleScope.launch {
        viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED, block)
    }
}

```

## app\src\main\java\com\example\pr23\viewmodel\SharedViewModel.kt

```kotlin
package com.example.pr23.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.pr23.data.MockRepository
import com.example.pr23.model.DeliveryState
import com.example.pr23.model.PaymentMethod
import com.example.pr23.model.RoutePoint
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class SharedViewModel(
    private val repository: MockRepository = MockRepository()
) : ViewModel() {

    private val _paymentMethods = MutableStateFlow(repository.getPaymentMethods())
    val paymentMethods: StateFlow<List<PaymentMethod>> = _paymentMethods.asStateFlow()

    private val _selectedPaymentMethod = MutableStateFlow(_paymentMethods.value.first())
    val selectedPaymentMethod: StateFlow<PaymentMethod> = _selectedPaymentMethod.asStateFlow()

    private val _routePoints = MutableStateFlow(repository.getRoutePoints())
    val routePoints: StateFlow<List<RoutePoint>> = _routePoints.asStateFlow()

    private val _deliveryState = MutableStateFlow(
        DeliveryState(
            progress = 0,
            statusText = "Доставка готовится к отправке",
            isCompleted = false
        )
    )
    val deliveryState: StateFlow<DeliveryState> = _deliveryState.asStateFlow()

    private var progressJob: Job? = null

    fun selectPaymentMethod(methodId: String) {
        val selected = _paymentMethods.value.firstOrNull { it.id == methodId }
        if (selected != null) {
            _selectedPaymentMethod.value = selected
        }
    }

    fun startDeliveryProgress() {
        if (progressJob?.isActive == true) return

        progressJob = viewModelScope.launch {
            for (progress in 0..100 step 5) {
                _deliveryState.value = DeliveryState(
                    progress = progress,
                    statusText = buildStatusText(progress),
                    isCompleted = progress == 100
                )
                delay(250)
            }
        }
    }

    fun restartDeliveryProgress() {
        progressJob?.cancel()
        progressJob = null
        _deliveryState.value = DeliveryState(
            progress = 0,
            statusText = "Доставка готовится к отправке",
            isCompleted = false
        )
        startDeliveryProgress()
    }

    private fun buildStatusText(progress: Int): String {
        return when (progress) {
            in 0..24 -> "Посылка оформлена"
            in 25..49 -> "Курьер забрал отправление"
            in 50..74 -> "Посылка движется по маршруту"
            in 75..99 -> "Курьер рядом с получателем"
            else -> "Доставка успешно завершена"
        }
    }
}

```

## app\src\main\java\com\example\pr23\MainActivity.kt

```kotlin
package com.example.pr23

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.ui.NavigationUI
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.example.pr23.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val navHostFragment = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavigationView.setupWithNavController(navController)

        binding.bottomNavigationView.setOnItemSelectedListener { item ->
            if (item.itemId == R.id.walletFragment) {
                val returnedToWallet = navController.popBackStack(R.id.walletFragment, false)
                if (!returnedToWallet && navController.currentDestination?.id != R.id.walletFragment) {
                    navController.navigate(R.id.walletFragment)
                }
                true
            } else {
                NavigationUI.onNavDestinationSelected(item, navController)
            }
        }
    }
}

```

## app\src\main\res\color\bottom_nav_item_color.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<selector xmlns:android="http://schemas.android.com/apk/res/android">
    <item android:color="@color/bottom_nav_selected" android:state_checked="true" />
    <item android:color="@color/bottom_nav_unselected" />
</selector>

```

## app\src\main\res\drawable\ic_app_logo.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="108dp"
    android:height="108dp"
    android:viewportWidth="108"
    android:viewportHeight="108">
    <path
        android:fillColor="#19A974"
        android:pathData="M54,6a48,48 0,1 0,0.1 0z" />
    <path
        android:fillColor="#FFFFFFFF"
        android:pathData="M28,42h32c5,0 9,4 9,9v17c0,5 -4,9 -9,9H35c-5,0 -9,-4 -9,-9V44c0,-1 1,-2 2,-2z" />
    <path
        android:fillColor="#2477D4"
        android:pathData="M36,32h22c3,0 6,2 8,5l5,8h-8l-3,-5c-1,-1 -2,-2 -4,-2H36c-3,0 -5,-1 -5,-3s2,-3 5,-3z" />
    <path
        android:fillColor="#F2994A"
        android:pathData="M38,77a7,7 0,1 0,0.1 0M62,77a7,7 0,1 0,0.1 0" />
</vector>

```

## app\src\main\res\drawable\ic_launcher_background.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="108dp"
    android:height="108dp"
    android:viewportWidth="108"
    android:viewportHeight="108">
    <path
        android:fillColor="#3DDC84"
        android:pathData="M0,0h108v108h-108z" />
    <path
        android:fillColor="#00000000"
        android:pathData="M9,0L9,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M19,0L19,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M29,0L29,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M39,0L39,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M49,0L49,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M59,0L59,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M69,0L69,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M79,0L79,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M89,0L89,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M99,0L99,108"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,9L108,9"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,19L108,19"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,29L108,29"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,39L108,39"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,49L108,49"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,59L108,59"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,69L108,69"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,79L108,79"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,89L108,89"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M0,99L108,99"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M19,29L89,29"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M19,39L89,39"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M19,49L89,49"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M19,59L89,59"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M19,69L89,69"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M19,79L89,79"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M29,19L29,89"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M39,19L39,89"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M49,19L49,89"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M59,19L59,89"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M69,19L69,89"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
    <path
        android:fillColor="#00000000"
        android:pathData="M79,19L79,89"
        android:strokeWidth="0.8"
        android:strokeColor="#33FFFFFF" />
</vector>

```

## app\src\main\res\drawable\ic_launcher_foreground.xml

```xml
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:aapt="http://schemas.android.com/aapt"
    android:width="108dp"
    android:height="108dp"
    android:viewportWidth="108"
    android:viewportHeight="108">
    <path android:pathData="M31,63.928c0,0 6.4,-11 12.1,-13.1c7.2,-2.6 26,-1.4 26,-1.4l38.1,38.1L107,108.928l-32,-1L31,63.928z">
        <aapt:attr name="android:fillColor">
            <gradient
                android:endX="85.84757"
                android:endY="92.4963"
                android:startX="42.9492"
                android:startY="49.59793"
                android:type="linear">
                <item
                    android:color="#44000000"
                    android:offset="0.0" />
                <item
                    android:color="#00000000"
                    android:offset="1.0" />
            </gradient>
        </aapt:attr>
    </path>
    <path
        android:fillColor="#FFFFFF"
        android:fillType="nonZero"
        android:pathData="M65.3,45.828l3.8,-6.6c0.2,-0.4 0.1,-0.9 -0.3,-1.1c-0.4,-0.2 -0.9,-0.1 -1.1,0.3l-3.9,6.7c-6.3,-2.8 -13.4,-2.8 -19.7,0l-3.9,-6.7c-0.2,-0.4 -0.7,-0.5 -1.1,-0.3C38.8,38.328 38.7,38.828 38.9,39.228l3.8,6.6C36.2,49.428 31.7,56.028 31,63.928h46C76.3,56.028 71.8,49.428 65.3,45.828zM43.4,57.328c-0.8,0 -1.5,-0.5 -1.8,-1.2c-0.3,-0.7 -0.1,-1.5 0.4,-2.1c0.5,-0.5 1.4,-0.7 2.1,-0.4c0.7,0.3 1.2,1 1.2,1.8C45.3,56.528 44.5,57.328 43.4,57.328L43.4,57.328zM64.6,57.328c-0.8,0 -1.5,-0.5 -1.8,-1.2s-0.1,-1.5 0.4,-2.1c0.5,-0.5 1.4,-0.7 2.1,-0.4c0.7,0.3 1.2,1 1.2,1.8C66.5,56.528 65.6,57.328 64.6,57.328L64.6,57.328z"
        android:strokeWidth="1"
        android:strokeColor="#00000000" />
</vector>
```

## app\src\main\res\drawable\ic_payment.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="24"
    android:viewportHeight="24">
    <path
        android:fillColor="#2477D4"
        android:pathData="M3,5h18c1.1,0 2,0.9 2,2v10c0,1.1 -0.9,2 -2,2H3c-1.1,0 -2,-0.9 -2,-2V7c0,-1.1 0.9,-2 2,-2z" />
    <path
        android:fillColor="#FFFFFFFF"
        android:pathData="M1,8h22v3H1zM5,15h6v2H5z" />
</vector>

```

## app\src\main\res\drawable\ic_success.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="24"
    android:viewportHeight="24">
    <path
        android:fillColor="#19A974"
        android:pathData="M12,2a10,10 0,1 0,0.1 0z" />
    <path
        android:fillColor="#FFFFFFFF"
        android:pathData="M10.2,15.8L6.4,12l1.6,-1.6 2.2,2.2 5.8,-5.8 1.6,1.6z" />
</vector>

```

## app\src\main\res\drawable\ic_tracking.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="24"
    android:viewportHeight="24">
    <path
        android:fillColor="#19A974"
        android:pathData="M12,2c-3.3,0 -6,2.7 -6,6 0,4.5 6,12 6,12s6,-7.5 6,-12c0,-3.3 -2.7,-6 -6,-6z" />
    <path
        android:fillColor="#FFFFFFFF"
        android:pathData="M12,5.5a2.5,2.5 0,1 0,0.1 0z" />
    <path
        android:fillColor="#F2994A"
        android:pathData="M4,21h16v2H4z" />
</vector>

```

## app\src\main\res\drawable\ic_wallet.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<vector xmlns:android="http://schemas.android.com/apk/res/android"
    android:width="24dp"
    android:height="24dp"
    android:viewportWidth="24"
    android:viewportHeight="24">
    <path
        android:fillColor="#66727D"
        android:pathData="M4,5h14c1.7,0 3,1.3 3,3v1h-5c-2.2,0 -4,1.8 -4,4s1.8,4 4,4h5v1c0,1.7 -1.3,3 -3,3H4c-1.7,0 -3,-1.3 -3,-3V8c0,-1.7 1.3,-3 3,-3z" />
    <path
        android:fillColor="#19A974"
        android:pathData="M16,11h6v4h-6c-1.1,0 -2,-0.9 -2,-2s0.9,-2 2,-2z" />
</vector>

```

## app\src\main\res\layout\activity_main.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.widget.ConstraintLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@color/screen_background">

    <!-- NavHostFragment хранит текущий экран. Все переходы выполняются через nav_graph.xml. -->
    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/nav_host_fragment"
        android:name="androidx.navigation.fragment.NavHostFragment"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:defaultNavHost="true"
        app:layout_constraintBottom_toTopOf="@id/bottomNavigationView"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toTopOf="parent"
        app:navGraph="@navigation/nav_graph" />

    <!-- id пунктов menu совпадают с id фрагментов в Navigation Graph. -->
    <com.google.android.material.bottomnavigation.BottomNavigationView
        android:id="@+id/bottomNavigationView"
        android:layout_width="0dp"
        android:layout_height="wrap_content"
        android:background="@color/surface"
        app:itemIconTint="@color/bottom_nav_item_color"
        app:itemTextColor="@color/bottom_nav_item_color"
        app:labelVisibilityMode="labeled"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:menu="@menu/bottom_nav_menu" />

</androidx.constraintlayout.widget.ConstraintLayout>

```

## app\src\main\res\layout\fragment_add_payment.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fillViewport="true">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="24dp">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/add_payment_title"
            android:textColor="@color/text_primary"
            android:textSize="28sp"
            android:textStyle="bold" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="8dp"
            android:text="@string/add_payment_subtitle"
            android:textColor="@color/text_secondary"
            android:textSize="16sp" />

        <!-- RadioGroup отправляет выбранный id во ViewModel, а выбранное состояние приходит обратно через StateFlow. -->
        <RadioGroup
            android:id="@+id/paymentRadioGroup"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="24dp"
            android:orientation="vertical">

            <RadioButton
                android:id="@+id/cardRadioButton"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:buttonTint="@color/delivery_green"
                android:text="@string/payment_card"
                android:textColor="@color/text_primary"
                android:textSize="18sp" />

            <TextView
                android:id="@+id/cardDescriptionText"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginStart="40dp"
                android:layout_marginBottom="14dp"
                android:textColor="@color/text_secondary"
                android:textSize="14sp" />

            <RadioButton
                android:id="@+id/cashRadioButton"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:buttonTint="@color/delivery_green"
                android:text="@string/payment_cash"
                android:textColor="@color/text_primary"
                android:textSize="18sp" />

            <TextView
                android:id="@+id/cashDescriptionText"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginStart="40dp"
                android:layout_marginBottom="14dp"
                android:textColor="@color/text_secondary"
                android:textSize="14sp" />

            <RadioButton
                android:id="@+id/walletRadioButton"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:buttonTint="@color/delivery_green"
                android:text="@string/payment_wallet"
                android:textColor="@color/text_primary"
                android:textSize="18sp" />

            <TextView
                android:id="@+id/walletDescriptionText"
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:layout_marginStart="40dp"
                android:textColor="@color/text_secondary"
                android:textSize="14sp" />
        </RadioGroup>

        <TextView
            android:id="@+id/selectedPaymentText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="28dp"
            android:textColor="@color/delivery_green_dark"
            android:textSize="18sp"
            android:textStyle="bold" />

        <com.google.android.material.button.MaterialButton
            android:id="@+id/backToWalletButton"
            style="@style/Widget.MaterialComponents.Button.OutlinedButton"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="24dp"
            android:text="@string/back_to_wallet"
            android:textColor="@color/delivery_green"
            app:icon="@drawable/ic_wallet"
            app:iconTint="@color/delivery_green"
            app:strokeColor="@color/delivery_green" />

    </LinearLayout>
</ScrollView>

```

## app\src\main\res\layout\fragment_delivery.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:gravity="center_horizontal"
    android:orientation="vertical"
    android:padding="24dp">

    <ImageView
        android:layout_width="96dp"
        android:layout_height="96dp"
        android:contentDescription="@string/delivery_success_title"
        android:src="@drawable/ic_success" />

    <TextView
        android:id="@+id/successTitleText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="24dp"
        android:gravity="center"
        android:textColor="@color/text_primary"
        android:textSize="28sp"
        android:textStyle="bold" />

    <TextView
        android:id="@+id/deliveryStatusText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="10dp"
        android:gravity="center"
        android:textColor="@color/text_secondary"
        android:textSize="17sp" />

    <!-- ProgressBar обновляется только из StateFlow DeliveryState во ViewModel. -->
    <ProgressBar
        android:id="@+id/deliveryProgressBar"
        style="?android:attr/progressBarStyleHorizontal"
        android:layout_width="match_parent"
        android:layout_height="18dp"
        android:layout_marginTop="36dp"
        android:max="100"
        android:progress="0"
        android:progressTint="@color/delivery_green" />

    <TextView
        android:id="@+id/progressValueText"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="12dp"
        android:gravity="center"
        android:textColor="@color/delivery_green_dark"
        android:textSize="20sp"
        android:textStyle="bold" />

    <com.google.android.material.button.MaterialButton
        android:id="@+id/restartProgressButton"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:layout_marginTop="32dp"
        android:text="@string/restart_progress"
        app:icon="@drawable/ic_success" />

</LinearLayout>

```

## app\src\main\res\layout\fragment_tracking.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:orientation="vertical">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="24dp">

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:text="@string/tracking_title"
            android:textColor="@color/text_primary"
            android:textSize="28sp"
            android:textStyle="bold" />

        <TextView
            android:id="@+id/routeSummaryText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="8dp"
            android:textColor="@color/text_secondary"
            android:textSize="16sp" />
    </LinearLayout>

    <!-- SupportMapFragment инициализируется во Fragment через childFragmentManager и getMapAsync. -->
    <androidx.fragment.app.FragmentContainerView
        android:id="@+id/mapFragment"
        android:name="com.google.android.gms.maps.SupportMapFragment"
        android:layout_width="match_parent"
        android:layout_height="0dp"
        android:layout_weight="1" />

</LinearLayout>

```

## app\src\main\res\layout\fragment_wallet.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<ScrollView xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:fillViewport="true">

    <LinearLayout
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:orientation="vertical"
        android:padding="24dp">

        <ImageView
            android:layout_width="72dp"
            android:layout_height="72dp"
            android:contentDescription="@string/app_logo_description"
            android:src="@drawable/ic_app_logo" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="20dp"
            android:text="@string/wallet_title"
            android:textColor="@color/text_primary"
            android:textSize="30sp"
            android:textStyle="bold" />

        <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="8dp"
            android:text="@string/wallet_subtitle"
            android:textColor="@color/text_secondary"
            android:textSize="16sp" />

        <TextView
            android:id="@+id/balanceText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="28dp"
            android:gravity="center"
            android:text="@string/wallet_balance"
            android:textColor="@color/delivery_green_dark"
            android:textSize="34sp"
            android:textStyle="bold" />

        <TextView
            android:id="@+id/paymentMethodText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="28dp"
            android:textColor="@color/text_primary"
            android:textSize="20sp"
            android:textStyle="bold" />

        <TextView
            android:id="@+id/paymentDescriptionText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="6dp"
            android:textColor="@color/text_secondary"
            android:textSize="15sp" />

        <TextView
            android:id="@+id/deliveryStatusText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="24dp"
            android:textColor="@color/text_primary"
            android:textSize="17sp"
            android:textStyle="bold" />

        <TextView
            android:id="@+id/deliveryProgressText"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="4dp"
            android:textColor="@color/text_secondary"
            android:textSize="15sp" />

        <!-- Кнопки демонстрируют переходы между destination через NavController. -->
        <com.google.android.material.button.MaterialButton
            android:id="@+id/addPaymentButton"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="28dp"
            android:text="@string/add_payment_title"
            app:icon="@drawable/ic_payment" />

        <com.google.android.material.button.MaterialButton
            android:id="@+id/trackPackageButton"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="12dp"
            android:text="@string/tracking_title"
            app:icon="@drawable/ic_tracking" />

        <com.google.android.material.button.MaterialButton
            android:id="@+id/deliveryStatusButton"
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            android:layout_marginTop="12dp"
            android:text="@string/delivery_success_title"
            app:icon="@drawable/ic_success" />

    </LinearLayout>
</ScrollView>

```

## app\src\main\res\menu\bottom_nav_menu.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:id="@+id/walletFragment"
        android:icon="@drawable/ic_wallet"
        android:title="@string/wallet_menu" />
    <item
        android:id="@+id/addPaymentFragment"
        android:icon="@drawable/ic_payment"
        android:title="@string/payment_menu" />
    <item
        android:id="@+id/trackingFragment"
        android:icon="@drawable/ic_tracking"
        android:title="@string/tracking_menu" />
    <item
        android:id="@+id/deliveryFragment"
        android:icon="@drawable/ic_success"
        android:title="@string/delivery_menu" />
</menu>

```

## app\src\main\res\navigation\nav_graph.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    android:id="@+id/nav_graph"
    app:startDestination="@id/walletFragment">

    <fragment
        android:id="@+id/walletFragment"
        android:name="com.example.pr23.ui.wallet.WalletFragment"
        android:label="@string/wallet_title">
        <action
            android:id="@+id/action_wallet_to_payment"
            app:destination="@id/addPaymentFragment" />
        <action
            android:id="@+id/action_wallet_to_tracking"
            app:destination="@id/trackingFragment" />
        <action
            android:id="@+id/action_wallet_to_delivery"
            app:destination="@id/deliveryFragment" />
    </fragment>

    <fragment
        android:id="@+id/addPaymentFragment"
        android:name="com.example.pr23.ui.payment.AddPaymentFragment"
        android:label="@string/add_payment_title" />

    <fragment
        android:id="@+id/trackingFragment"
        android:name="com.example.pr23.ui.tracking.TrackingFragment"
        android:label="@string/tracking_title" />

    <fragment
        android:id="@+id/deliveryFragment"
        android:name="com.example.pr23.ui.delivery.DeliveryFragment"
        android:label="@string/delivery_success_title" />
</navigation>

```

## app\src\main\res\values\colors.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <color name="screen_background">#F7F8FA</color>
    <color name="surface">#FFFFFFFF</color>
    <color name="text_primary">#172026</color>
    <color name="text_secondary">#66727D</color>
    <color name="delivery_green">#19A974</color>
    <color name="delivery_green_dark">#087A54</color>
    <color name="delivery_blue">#2477D4</color>
    <color name="delivery_orange">#F2994A</color>
    <color name="bottom_nav_selected">#19A974</color>
    <color name="bottom_nav_unselected">#7A8791</color>
    <color name="white">#FFFFFFFF</color>
</resources>

```

## app\src\main\res\values\strings.xml

```xml
<resources>
    <string name="app_name">DeliveryApp</string>
    <string name="google_maps_api_key">PASTE_YOUR_GOOGLE_MAPS_API_KEY_HERE</string>
    <string name="app_logo_description">Логотип DeliveryApp</string>
    <string name="wallet_title">Wallet</string>
    <string name="wallet_subtitle">Кошелек доставки, выбранная оплата и быстрый доступ ко всем экранам.</string>
    <string name="wallet_balance">2 450 ₽</string>
    <string name="wallet_menu">Wallet</string>
    <string name="payment_menu">Payment</string>
    <string name="tracking_menu">Tracking</string>
    <string name="delivery_menu">Success</string>
    <string name="add_payment_title">Add Payment method</string>
    <string name="add_payment_subtitle">Выберите способ оплаты. RadioButton меняет состояние в SharedViewModel.</string>
    <string name="payment_card">Банковская карта</string>
    <string name="payment_cash">Наличные</string>
    <string name="payment_wallet">Delivery Wallet</string>
    <string name="selected_payment_format">Выбрано: %1$s</string>
    <string name="back_to_wallet">Вернуться в Wallet</string>
    <string name="tracking_title">Tracking Package</string>
    <string name="route_summary_format">Маршрут: %1$s → %2$s</string>
    <string name="delivery_success_title">Delivery successful-1</string>
    <string name="delivery_in_progress_title">Доставка выполняется</string>
    <string name="delivery_progress_format">%1$d%%</string>
    <string name="restart_progress">Повторить анимацию прогресса</string>
</resources>

```

## app\src\main\res\values\styles.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <style name="Widget.DeliveryApp.Button" parent="Widget.MaterialComponents.Button">
        <item name="cornerRadius">10dp</item>
    </style>
</resources>

```

## app\src\main\res\values\themes.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<resources>
    <style name="Theme.DeliveryApp" parent="Theme.MaterialComponents.DayNight.NoActionBar">
        <item name="colorPrimary">@color/delivery_green</item>
        <item name="colorPrimaryVariant">@color/delivery_green_dark</item>
        <item name="colorSecondary">@color/delivery_blue</item>
        <item name="android:windowLightStatusBar">true</item>
        <item name="android:statusBarColor">@color/screen_background</item>
        <item name="android:navigationBarColor">@color/surface</item>
        <item name="android:fontFamily">sans</item>
    </style>
</resources>

```

## app\src\main\res\xml\backup_rules.xml

```xml
<?xml version="1.0" encoding="utf-8"?><!--
   Sample backup rules file; uncomment and customize as necessary.
   See https://developer.android.com/guide/topics/data/autobackup
   for details.
   Note: This file is ignored for devices older than API 31
   See https://developer.android.com/about/versions/12/backup-restore
-->
<full-backup-content>
    <!--
   <include domain="sharedpref" path="."/>
   <exclude domain="sharedpref" path="device.xml"/>
-->
</full-backup-content>
```

## app\src\main\res\xml\data_extraction_rules.xml

```xml
<?xml version="1.0" encoding="utf-8"?><!--
   Sample data extraction rules file; uncomment and customize as necessary.
   See https://developer.android.com/about/versions/12/backup-restore#xml-changes
   for details.
-->
<data-extraction-rules>
    <cloud-backup>
        <!-- TODO: Use <include> and <exclude> to control what is backed up.
        <include .../>
        <exclude .../>
        -->
    </cloud-backup>
    <!--
    <device-transfer>
        <include .../>
        <exclude .../>
    </device-transfer>
    -->
</data-extraction-rules>
```

## app\src\main\AndroidManifest.xml

```xml
<?xml version="1.0" encoding="utf-8"?>
<manifest xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:tools="http://schemas.android.com/tools">

    <uses-permission android:name="android.permission.INTERNET" />
    <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />

    <application
        android:allowBackup="true"
        android:dataExtractionRules="@xml/data_extraction_rules"
        android:fullBackupContent="@xml/backup_rules"
        android:icon="@drawable/ic_app_logo"
        android:label="@string/app_name"
        android:roundIcon="@drawable/ic_app_logo"
        android:supportsRtl="true"
        android:theme="@style/Theme.DeliveryApp">

        <meta-data
            android:name="com.google.android.geo.API_KEY"
            android:value="@string/google_maps_api_key" />

        <activity
            android:name=".MainActivity"
            android:exported="true"
            android:label="@string/app_name"
            android:theme="@style/Theme.DeliveryApp">
            <intent-filter>
                <action android:name="android.intent.action.MAIN" />

                <category android:name="android.intent.category.LAUNCHER" />
            </intent-filter>
        </activity>
    </application>

</manifest>

```

## app\src\test\java\com\example\pr23\ExampleUnitTest.kt

```kotlin
package com.example.pr23

import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {
        assertEquals(4, 2 + 2)
    }
}
```

## app\.gitignore

```
/build
```

## app\build.gradle.kts

```
plugins {
    alias(libs.plugins.android.application)
}

android {
    namespace = "com.example.pr23"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.pr23"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    buildFeatures {
        viewBinding = true
    }
}

dependencies {
    implementation(libs.androidx.core)
    implementation(libs.androidx.appcompat)
    implementation(libs.androidx.constraintlayout)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.lifecycle.viewmodel.ktx)
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.google.android.material)
    implementation(libs.google.play.services.maps)

    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}

```

## app\proguard-rules.pro

```
# Add project specific ProGuard rules here.
# You can control the set of applied configuration files using the
# proguardFiles setting in build.gradle.
#
# For more details, see
#   http://developer.android.com/guide/developing/tools/proguard.html

# If your project uses WebView with JS, uncomment the following
# and specify the fully qualified class name to the JavaScript interface
# class:
#-keepclassmembers class fqcn.of.javascript.interface.for.webview {
#   public *;
#}

# Uncomment this to preserve the line number information for
# debugging stack traces.
#-keepattributes SourceFile,LineNumberTable

# If you keep the line number information, uncomment this to
# hide the original source file name.
#-renamesourcefileattribute SourceFile
```

## gradle\wrapper\gradle-wrapper.properties

```
#Fri May 08 09:13:53 NOVT 2026
distributionBase=GRADLE_USER_HOME
distributionPath=wrapper/dists
distributionSha256Sum=72f44c9f8ebcb1af43838f45ee5c4aa9c5444898b3468ab3f4af7b6076c5bc3f
distributionUrl=https\://services.gradle.org/distributions/gradle-9.2.1-bin.zip
networkTimeout=10000
validateDistributionUrl=true
zipStoreBase=GRADLE_USER_HOME
zipStorePath=wrapper/dists

```

## gradle\gradle-daemon-jvm.properties

```
#This file is generated by updateDaemonJvm
toolchainUrl.FREE_BSD.AARCH64=https\://api.foojay.io/disco/v3.0/ids/ec7520a1e057cd116f9544c42142a16b/redirect
toolchainUrl.FREE_BSD.X86_64=https\://api.foojay.io/disco/v3.0/ids/4c4f879899012ff0a8b2e2117df03b0e/redirect
toolchainUrl.LINUX.AARCH64=https\://api.foojay.io/disco/v3.0/ids/ec7520a1e057cd116f9544c42142a16b/redirect
toolchainUrl.LINUX.X86_64=https\://api.foojay.io/disco/v3.0/ids/4c4f879899012ff0a8b2e2117df03b0e/redirect
toolchainUrl.MAC_OS.AARCH64=https\://api.foojay.io/disco/v3.0/ids/73bcfb608d1fde9fb62e462f834a3299/redirect
toolchainUrl.MAC_OS.X86_64=https\://api.foojay.io/disco/v3.0/ids/846ee0d876d26a26f37aa1ce8de73224/redirect
toolchainUrl.UNIX.AARCH64=https\://api.foojay.io/disco/v3.0/ids/ec7520a1e057cd116f9544c42142a16b/redirect
toolchainUrl.UNIX.X86_64=https\://api.foojay.io/disco/v3.0/ids/4c4f879899012ff0a8b2e2117df03b0e/redirect
toolchainUrl.WINDOWS.AARCH64=https\://api.foojay.io/disco/v3.0/ids/9482ddec596298c84656d31d16652665/redirect
toolchainUrl.WINDOWS.X86_64=https\://api.foojay.io/disco/v3.0/ids/39701d92e1756bb2f141eb67cd4c660e/redirect
toolchainVersion=21

```

## gradle\libs.versions.toml

```
[versions]
agp = "9.0.1"
core = "1.13.0"
junit = "4.13.2"
junitVersion = "1.1.5"
espressoCore = "3.5.1"
lifecycleRuntimeKtx = "2.7.0"
appcompat = "1.7.1"
constraintlayout = "2.2.1"
kotlin = "2.0.21"
lifecycleViewmodelKtx = "2.7.0"
material = "1.13.0"
navigation = "2.7.7"
playServicesMaps = "18.2.0"

[libraries]
androidx-core = { group = "androidx.core", name = "core", version.ref = "core" }
junit = { group = "junit", name = "junit", version.ref = "junit" }
androidx-junit = { group = "androidx.test.ext", name = "junit", version.ref = "junitVersion" }
androidx-espresso-core = { group = "androidx.test.espresso", name = "espresso-core", version.ref = "espressoCore" }
androidx-lifecycle-runtime-ktx = { group = "androidx.lifecycle", name = "lifecycle-runtime-ktx", version.ref = "lifecycleRuntimeKtx" }
androidx-appcompat = { group = "androidx.appcompat", name = "appcompat", version.ref = "appcompat" }
androidx-constraintlayout = { group = "androidx.constraintlayout", name = "constraintlayout", version.ref = "constraintlayout" }
androidx-lifecycle-viewmodel-ktx = { group = "androidx.lifecycle", name = "lifecycle-viewmodel-ktx", version.ref = "lifecycleViewmodelKtx" }
androidx-navigation-fragment-ktx = { group = "androidx.navigation", name = "navigation-fragment-ktx", version.ref = "navigation" }
androidx-navigation-ui-ktx = { group = "androidx.navigation", name = "navigation-ui-ktx", version.ref = "navigation" }
google-android-material = { group = "com.google.android.material", name = "material", version.ref = "material" }
google-play-services-maps = { group = "com.google.android.gms", name = "play-services-maps", version.ref = "playServicesMaps" }

[plugins]
android-application = { id = "com.android.application", version.ref = "agp" }
kotlin-android = { id = "org.jetbrains.kotlin.android", version.ref = "kotlin" }

```

## .gitignore

```
*.iml
.gradle
/local.properties
/.idea/caches
/.idea/libraries
/.idea/modules.xml
/.idea/workspace.xml
/.idea/navEditor.xml
/.idea/assetWizardSettings.xml
.DS_Store
/build
/captures
.externalNativeBuild
.cxx
local.properties

```

## build.gradle.kts

```
// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    alias(libs.plugins.android.application) apply false
}

```

## gradle.properties

```
# Project-wide Gradle settings.
# IDE (e.g. Android Studio) users:
# Gradle settings configured through the IDE *will override*
# any settings specified in this file.
# For more details on how to configure your build environment visit
# http://www.gradle.org/docs/current/userguide/build_environment.html
# Specifies the JVM arguments used for the daemon process.
# The setting is particularly useful for tweaking memory settings.
org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8
org.gradle.java.home=C\:\\Program Files\\Android\\Android Studio\\jbr
# When configured, Gradle will run in incubating parallel mode.
# This option should only be used with decoupled projects. For more details, visit
# https://developer.android.com/r/tools/gradle-multi-project-decoupled-projects
# org.gradle.parallel=true
# AndroidX package structure to make it clearer which packages are bundled with the
# Android operating system, and which are packaged with your app's APK
# https://developer.android.com/topic/libraries/support-library/androidx-rn
android.useAndroidX=true
# Kotlin code style for this project: "official" or "obsolete":
kotlin.code.style=official
# Enables namespacing of each library's R class so that its R class includes only the
# resources declared in the library itself and none from the library's dependencies,
# thereby reducing the size of the R class for that library
android.nonTransitiveRClass=true

```

## gradlew

```
#!/bin/sh

#
# Copyright © 2015 the original authors.
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      https://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#
# SPDX-License-Identifier: Apache-2.0
#

##############################################################################
#
#   Gradle start up script for POSIX generated by Gradle.
#
#   Important for running:
#
#   (1) You need a POSIX-compliant shell to run this script. If your /bin/sh is
#       noncompliant, but you have some other compliant shell such as ksh or
#       bash, then to run this script, type that shell name before the whole
#       command line, like:
#
#           ksh Gradle
#
#       Busybox and similar reduced shells will NOT work, because this script
#       requires all of these POSIX shell features:
#         * functions;
#         * expansions «$var», «${var}», «${var:-default}», «${var+SET}»,
#           «${var#prefix}», «${var%suffix}», and «$( cmd )»;
#         * compound commands having a testable exit status, especially «case»;
#         * various built-in commands including «command», «set», and «ulimit».
#
#   Important for patching:
#
#   (2) This script targets any POSIX shell, so it avoids extensions provided
#       by Bash, Ksh, etc; in particular arrays are avoided.
#
#       The "traditional" practice of packing multiple parameters into a
#       space-separated string is a well documented source of bugs and security
#       problems, so this is (mostly) avoided, by progressively accumulating
#       options in "$@", and eventually passing that to Java.
#
#       Where the inherited environment variables (DEFAULT_JVM_OPTS, JAVA_OPTS,
#       and GRADLE_OPTS) rely on word-splitting, this is performed explicitly;
#       see the in-line comments for details.
#
#       There are tweaks for specific operating systems such as AIX, CygWin,
#       Darwin, MinGW, and NonStop.
#
#   (3) This script is generated from the Groovy template
#       https://github.com/gradle/gradle/blob/HEAD/platforms/jvm/plugins-application/src/main/resources/org/gradle/api/internal/plugins/unixStartScript.txt
#       within the Gradle project.
#
#       You can find Gradle at https://github.com/gradle/gradle/.
#
##############################################################################

# Attempt to set APP_HOME

# Resolve links: $0 may be a link
app_path=$0

# Need this for daisy-chained symlinks.
while
    APP_HOME=${app_path%"${app_path##*/}"}  # leaves a trailing /; empty if no leading path
    [ -h "$app_path" ]
do
    ls=$( ls -ld "$app_path" )
    link=${ls#*' -> '}
    case $link in             #(
      /*)   app_path=$link ;; #(
      *)    app_path=$APP_HOME$link ;;
    esac
done

# This is normally unused
# shellcheck disable=SC2034
APP_BASE_NAME=${0##*/}
# Discard cd standard output in case $CDPATH is set (https://github.com/gradle/gradle/issues/25036)
APP_HOME=$( cd -P "${APP_HOME:-./}" > /dev/null && printf '%s\n' "$PWD" ) || exit

# Use the maximum available, or set MAX_FD != -1 to use that value.
MAX_FD=maximum

warn () {
    echo "$*"
} >&2

die () {
    echo
    echo "$*"
    echo
    exit 1
} >&2

# OS specific support (must be 'true' or 'false').
cygwin=false
msys=false
darwin=false
nonstop=false
case "$( uname )" in                #(
  CYGWIN* )         cygwin=true  ;; #(
  Darwin* )         darwin=true  ;; #(
  MSYS* | MINGW* )  msys=true    ;; #(
  NONSTOP* )        nonstop=true ;;
esac

CLASSPATH="\\\"\\\""


# Determine the Java command to use to start the JVM.
if [ -n "$JAVA_HOME" ] ; then
    if [ -x "$JAVA_HOME/jre/sh/java" ] ; then
        # IBM's JDK on AIX uses strange locations for the executables
        JAVACMD=$JAVA_HOME/jre/sh/java
    else
        JAVACMD=$JAVA_HOME/bin/java
    fi
    if [ ! -x "$JAVACMD" ] ; then
        die "ERROR: JAVA_HOME is set to an invalid directory: $JAVA_HOME

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
    fi
else
    JAVACMD=java
    if ! command -v java >/dev/null 2>&1
    then
        die "ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH.

Please set the JAVA_HOME variable in your environment to match the
location of your Java installation."
    fi
fi

# Increase the maximum file descriptors if we can.
if ! "$cygwin" && ! "$darwin" && ! "$nonstop" ; then
    case $MAX_FD in #(
      max*)
        # In POSIX sh, ulimit -H is undefined. That's why the result is checked to see if it worked.
        # shellcheck disable=SC2039,SC3045
        MAX_FD=$( ulimit -H -n ) ||
            warn "Could not query maximum file descriptor limit"
    esac
    case $MAX_FD in  #(
      '' | soft) :;; #(
      *)
        # In POSIX sh, ulimit -n is undefined. That's why the result is checked to see if it worked.
        # shellcheck disable=SC2039,SC3045
        ulimit -n "$MAX_FD" ||
            warn "Could not set maximum file descriptor limit to $MAX_FD"
    esac
fi

# Collect all arguments for the java command, stacking in reverse order:
#   * args from the command line
#   * the main class name
#   * -classpath
#   * -D...appname settings
#   * --module-path (only if needed)
#   * DEFAULT_JVM_OPTS, JAVA_OPTS, and GRADLE_OPTS environment variables.

# For Cygwin or MSYS, switch paths to Windows format before running java
if "$cygwin" || "$msys" ; then
    APP_HOME=$( cygpath --path --mixed "$APP_HOME" )
    CLASSPATH=$( cygpath --path --mixed "$CLASSPATH" )

    JAVACMD=$( cygpath --unix "$JAVACMD" )

    # Now convert the arguments - kludge to limit ourselves to /bin/sh
    for arg do
        if
            case $arg in                                #(
              -*)   false ;;                            # don't mess with options #(
              /?*)  t=${arg#/} t=/${t%%/*}              # looks like a POSIX filepath
                    [ -e "$t" ] ;;                      #(
              *)    false ;;
            esac
        then
            arg=$( cygpath --path --ignore --mixed "$arg" )
        fi
        # Roll the args list around exactly as many times as the number of
        # args, so each arg winds up back in the position where it started, but
        # possibly modified.
        #
        # NB: a `for` loop captures its iteration list before it begins, so
        # changing the positional parameters here affects neither the number of
        # iterations, nor the values presented in `arg`.
        shift                   # remove old arg
        set -- "$@" "$arg"      # push replacement arg
    done
fi


# Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
DEFAULT_JVM_OPTS='"-Xmx64m" "-Xms64m"'

# Collect all arguments for the java command:
#   * DEFAULT_JVM_OPTS, JAVA_OPTS, and optsEnvironmentVar are not allowed to contain shell fragments,
#     and any embedded shellness will be escaped.
#   * For example: A user cannot expect ${Hostname} to be expanded, as it is an environment variable and will be
#     treated as '${Hostname}' itself on the command line.

set -- \
        "-Dorg.gradle.appname=$APP_BASE_NAME" \
        -classpath "$CLASSPATH" \
        -jar "$APP_HOME/gradle/wrapper/gradle-wrapper.jar" \
        "$@"

# Stop when "xargs" is not available.
if ! command -v xargs >/dev/null 2>&1
then
    die "xargs is not available"
fi

# Use "xargs" to parse quoted args.
#
# With -n1 it outputs one arg per line, with the quotes and backslashes removed.
#
# In Bash we could simply go:
#
#   readarray ARGS < <( xargs -n1 <<<"$var" ) &&
#   set -- "${ARGS[@]}" "$@"
#
# but POSIX shell has neither arrays nor command substitution, so instead we
# post-process each arg (as a line of input to sed) to backslash-escape any
# character that might be a shell metacharacter, then use eval to reverse
# that process (while maintaining the separation between arguments), and wrap
# the whole thing up as a single "set" statement.
#
# This will of course break if any of these variables contains a newline or
# an unmatched quote.
#

eval "set -- $(
        printf '%s\n' "$DEFAULT_JVM_OPTS $JAVA_OPTS $GRADLE_OPTS" |
        xargs -n1 |
        sed ' s~[^-[:alnum:]+,./:=@_]~\\&~g; ' |
        tr '\n' ' '
    )" '"$@"'

exec "$JAVACMD" "$@"

```

## gradlew.bat

```
@rem
@rem Copyright 2015 the original author or authors.
@rem
@rem Licensed under the Apache License, Version 2.0 (the "License");
@rem you may not use this file except in compliance with the License.
@rem You may obtain a copy of the License at
@rem
@rem      https://www.apache.org/licenses/LICENSE-2.0
@rem
@rem Unless required by applicable law or agreed to in writing, software
@rem distributed under the License is distributed on an "AS IS" BASIS,
@rem WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
@rem See the License for the specific language governing permissions and
@rem limitations under the License.
@rem
@rem SPDX-License-Identifier: Apache-2.0
@rem

@if "%DEBUG%"=="" @echo off
@rem ##########################################################################
@rem
@rem  Gradle startup script for Windows
@rem
@rem ##########################################################################

@rem Set local scope for the variables with windows NT shell
if "%OS%"=="Windows_NT" setlocal

set DIRNAME=%~dp0
if "%DIRNAME%"=="" set DIRNAME=.
@rem This is normally unused
set APP_BASE_NAME=%~n0
set APP_HOME=%DIRNAME%

@rem Resolve any "." and ".." in APP_HOME to make it shorter.
for %%i in ("%APP_HOME%") do set APP_HOME=%%~fi

@rem Add default JVM options here. You can also use JAVA_OPTS and GRADLE_OPTS to pass JVM options to this script.
set DEFAULT_JVM_OPTS="-Xmx64m" "-Xms64m"

@rem Find java.exe
if defined JAVA_HOME goto findJavaFromJavaHome

set JAVA_EXE=java.exe
%JAVA_EXE% -version >NUL 2>&1
if %ERRORLEVEL% equ 0 goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is not set and no 'java' command could be found in your PATH. 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:findJavaFromJavaHome
set JAVA_HOME=%JAVA_HOME:"=%
set JAVA_EXE=%JAVA_HOME%/bin/java.exe

if exist "%JAVA_EXE%" goto execute

echo. 1>&2
echo ERROR: JAVA_HOME is set to an invalid directory: %JAVA_HOME% 1>&2
echo. 1>&2
echo Please set the JAVA_HOME variable in your environment to match the 1>&2
echo location of your Java installation. 1>&2

goto fail

:execute
@rem Setup the command line

set CLASSPATH=


@rem Execute Gradle
"%JAVA_EXE%" %DEFAULT_JVM_OPTS% %JAVA_OPTS% %GRADLE_OPTS% "-Dorg.gradle.appname=%APP_BASE_NAME%" -classpath "%CLASSPATH%" -jar "%APP_HOME%\gradle\wrapper\gradle-wrapper.jar" %*

:end
@rem End local scope for the variables with windows NT shell
if %ERRORLEVEL% equ 0 goto mainEnd

:fail
rem Set variable GRADLE_EXIT_CONSOLE if you need the _script_ return code instead of
rem the _cmd.exe /c_ return code!
set EXIT_CODE=%ERRORLEVEL%
if %EXIT_CODE% equ 0 set EXIT_CODE=1
if not ""=="%GRADLE_EXIT_CONSOLE%" exit %EXIT_CODE%
exit /b %EXIT_CODE%

:mainEnd
if "%OS%"=="Windows_NT" endlocal

:omega

```

## settings.gradle.kts

```
pluginManagement {
    repositories {
        google {
            content {
                includeGroupByRegex("com\\.android.*")
                includeGroupByRegex("com\\.google.*")
                includeGroupByRegex("androidx.*")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "PR23"
include(":app")
 

```

## ПЗ.23 Создание структуры проекта в соответствии с паттерном.docx

```
PK     ! �ªp�  1   [Content_Types].xml �(�                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ĕ�N�0E�H�C�-j�v�jʂ�*[מ�~ɞB��L��J�����x���k�3�YZ�}@Lڻ��>��I������wŲ��)a���� ������e e��R����$�`E�} G+��V ��B���a�ɥw{Xi���J�0��/��$�I,��V^!-�:�p�Ko�S�&�uHT�x�C���`��D�D� �����R��Qq���Rg~X��ӗ��P�Wj!z	)Q���������8�"��o�p�`'ч48��� ��:ýY���B$����n�H�2���`��n����V���ϝQ|o)�G籋Ө�[!���v�G� ���1�G��џ���@[�V�����'��9dI�님F\�Ŷw3��n�ڑ�O�T�Q�j���?�  �� PK     ! ���   N   _rels/.rels �(�                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                 ���j�0@���ѽQ���N/c���[IL��j���<��]�aG��ӓ�zs�Fu��]��U��	��^�[��x ����1x�p����f��#I)ʃ�Y���������*D��i")��c$���qU���~3��1��jH[{�=E����~
f?��3-���޲]�Tꓸ2�j)�,l0/%��b�
���z���ŉ�,	�	�/�|f\Z���?6�!Y�_�o�]A�  �� PK     ! �j.v  l   word/_rels/document.xml.rels �(�                                                                                                                                                                                                                                                                 �VMO�@�W��|���8�PZ��JE�Jܪ�=^��kwM0����I�Bݦ���N�7o�|���݃�\�$��~���+�׳��]г���
� 	��x������l�+�Ce��t�zO��J��F����H��i�hvG�A��OL#���;͓�����T�'غ(x�tVKP��D$#��CPj��E��|�IeZ�,g��������L�\ͧ�ɤ�EM.��������+*�J��<�Ã�*�K�[�.�����=�¤gC�dg�q/�Y���I0}p`/ �+_P�����r�H*4#�Ԗ�����+!4��.�ӆ����Z�Ml�٘"D���Z�l��ջ���O��r�]����E!�PU�45�J25)��L1��_s�ߵt��Vh�ȴ�f�ti�U2U���-���3q��^����O�Ym����mC!��V��N6�����6�NI�j�C3I�r�Ko}�Cz�aᶄk;��ʤC�F׮�R ���&;�=����%��po�1����#ٕ��
���:9}R��/[w�\;;u!������֖.
^e���#5��m�L�9��o�>�5Ë�u�
2��݂�%��x���tہ�4�ǎ�  �� PK     ! �)�sF0  n�    word/document.xml�]�rǙ�ߪ}�Y^��-�8Jˣ�J��,��^����D`X (���Dٲ���(�]�+��d�T(J�(�����Wȓ�����`�� ġ�$3=�������G��v�(��faa*2�ҌB�����~����ܔV*�=g���}�4u��?��O��7��n�(�56D�4���Y��.�w�C�Rf����|6S4K�fy6c�C��f6c����F(��鯝��1J%��e�pS/M��2u6�FQ�cc�x(����G�1"]��Cs�囗f���Y��e�������;3l���]���}6d8)�1�v��y1�Lm*xd�OE��O;y/dE���*96�P����`��;�r[r��"n�s򾽝H�7�X�X����*�9>��#F�`CԞ�d
�wʙ��l��b_��7��n�h� ɒ��	1D��������VoX~�h���G��6�;��� ��KP���K�M�����X9��g�`���ý�Ч4p��&M�͍}�����4�xoa*N�c�ŵ)yi���ws��o��.� ׊��zy?��1S�-L鉩�����z�_.},/D�w�j���=�7_�b��:�^Y'���;V�z�~[�ua=�޲���c�7=Ь���E�6{�	�Ğ�Nٵ��uf�'xK����s\������#�π�c���/@:���'H��������2���=�W�n@���W��Y�5v����Ҭ��Z�g5��#�zP���>��ޜ��Gf�����%����=��������n��ò����a�}2�>zDO��#�����ǎ�1�83g��Ͳ�g��r���}�������l����Yo���q0���_������f�X*�g2F�1��O�/���n���^^�[
�ϖ��]����ϡF*o��s��fchD8�H��m�,h��2YX.j���~���sKI�r������R�:o|�θSp!�k&��E'��.;�I\�J���f(����+���l#l+w�sB0Rbga�DSI�7���.��:]�.#�0��(:DKq�,�K����2S��l�(i�4���̼^�����RV_�Z�s��b���ޞ)5_v�Z���W;��tZU��Fa���۫�r�sf�PJ���Q2�7��+���^a��iO��#�T��k�kO�%�,��9=��L��f��5ӽ�:�>ӳܖ�J�k`ֱ�pz6ܸ*�V�Hp���g��^jt��7)�sg������2�s�	&�.H�#��zȜ&��;�B�	�#�������V�
Ӻڡ�_w12��[����e�Ӭ?�3&@�+���Ig_0*�ம���������)0�7a��挈Z�����@W����a���5�(�A9�k8��pJS���T���,���YY*�RQ���T���,fe�-��u��)i�~�k�� �r�������r�7xj�d�8����vqk]�&3 �:����D�7�ȕc�X,B��ƅ;����K�-�ydHb��kd�uc�,2pG��q��^�"
�d��=��	�D8���:����t7m�^�6�J�6�T�&��d"�����6��i�s��(���c�6���ט/�I�!�:)��L����O�iE�	_�U=�N����!3����=�.��=��A��1����Nx��p�]�+?�X��W�]I&��|3�Dѯ��D��H|mi ��d���?��y=sԷ2>���h�V^|ڣC��%^!;"����N�@�+�>���l\���"���r����&��W2(��-��1��L���ح,�����$s��u��*g$<��7�l�f�w���{�f�b�ٛ�6�H-��I� (�����ɒ
f���̉��~�8.�oo�5L?�"�=������m.��UE���p#c �4l�}Sl�x�X�d"?!��r.�v��4K���	�TO(u��oj�^��ؔ>�t}��=�Y�?��t���MS�ҾC��I�y����䡞��j���g�Wתt�L�o�lllllll�	���j,��ɤH��m���d�lV�G���%fNʼ[=Є ip��b}���|KBD!�)6�A�IND�vI��
�˔��E���]y�:X�����[����^M&�+R��ن�gE�H�v��s7�J�.��w�Ԥ���R��)�(�����!��뾥�^�̲-���adz�(lEc���R�б��x��P��I�.�h[2��TOۂ�ݣITXu���2��z
r�,o;PX� �sXB�C�*��Y*NG�>C�+EQzMyTy��n�^�j5���	~V��ޙz�F'���'�ϩ�El�@���W�;�f8�.��{�>q3oU���`a�zts��������[-� c�o�!�;ܥ<���|É��k#�m[ĕ�nț�)�4t,��챊�J�Gj�u$X���J'�wF�(R�gx���q�!!�])��;��T��F5��n<�sec�F�>�3���8�*߭�T�UU��*�Z���^��t&�&�R�T� �&"	Λ�A���ՌHFg�喌�νw��z!>Y�6�� ҫ�=�{�	��_Q�\K�;u�'B���?7:i��PȄ;���*j��ܢ&�>;��7�a��� L�؆�y|,�/(���;�Uw�Hu-���e��E��q�����Qk�V'����?�V0v}�T;,�W�?�^,T{�eE�����9Ng�M��:�TH~��4\�Y��-V�!{�/��E�ie��M�dbym�'
x�d�0D�3&F�$����ww~��B8�$����^FĆ��v��0����f�j�l�CT|��~xA�H���;�g�k��H�0�{9��E�����vu����5蠑 �UBw1��/�+��]ç\=�ו͗v����i�ė-�!��>Yx�'Ҷ��ޡY6�h�]Sπ	�_�B<�$���Rre�Qx���"=� ��#��ru�FY��}X��R=샬]����)Fl#��U�9�?9PWXq�<d��GBй�Xpb(@��8��ڦn��Q4�����F�l���p�)6(�]QB��G���Ȃh�[� ����`h�]��zs���z���d��Q��OY'�(�_��Oѱ�DҞ�E�j4���F%����/�H
�ё�^U;��~_�K/��/��%�f��nj�KQK���=�I� P�!<r���|ߺ��V�+�՚�4�������fw0�[d�T:�L�8�΍���J����V%��h"�$YD|K �u<���@�Y��Oof���F7;�3'PMN�Ğ�E�9�kh���~ia5�
']��*ZV�=b���|�ŷg{��{�����y=�v̅�=���k����^���3̚�����f3E�dn�[���>�(�~/�C��q��B4�	E�4I-a��)���-{�v7�i�N�?�\��+}#0��+��^P҆W����$���Dj-�H�b=l�R��-��t*?:9#�Is��U���o$Mlt�{J�< �}�Z �w�ˋ��Y@�䑨�'2IS_l� �Xqv�y�U������*��Z[9qЇ��*����ggN�7h�z8>���FbW�JmS#�\V��WzmP��t8�[v#`�7�C�b�=�����K�)G<�����g�#�`;*�0��	��: ����=-)K3xK���W5�{�w_�z?с����K؍�,m�~�����%b#��MI�c�aE*����[L" ]���i���J$S��p"��TT?�zS�`�
Y|��g�8��t��6��<_�Mn�β�l��N�b��)C���W�𹸜�����m�ʈ~KtG9�HMt�	��52�[���Пȵ��uY̎Éo7D����wEA���I�ژXo��^��=���j���(b+�g�K��
m[~�'�qƙ��=C�k'.'�-�^TʪO􂪻gZ}�:m�"���%���U���'����0�s�뫟��y�#���]B_T�A�M��U�<�h����[];٫ta8`Vd:���&�o(0���=yo�)1q���]Yk�o�R�i��,�v_��W�}��`j���r�}��.:�D�8c�=���j�L�����'h�$��G�+�6l�Ćd�O!6�����W8듾RK��(i6�o}��z��v@6c�Yd��9�]/�-�o���akoh�y@J���(�@�>=� �h�d��/��gt掲z���3yI��D�{l��Y��0�P/���g_m�.L]�ϯ�9z��0���Ȼ���\�<�����q^���Id*d�����/۵��^���F�ڽ])0q�FV
l����#�H��¿P�K���B�R_��k7|Sʄ?�x�T��~^��s��AGߔ�}��$7�	�<�<�[��Q)�1�#HU��<!��~T�q|�c�z|��hC���J3*��J�L�}7�<W��5U:P�@�/�]2q��:+[��c���t*�yw�^5t.O
��8���[�hڌVX�yҖ��z��������������A;oW����;1�;�\��bY�d�eC
<����1���u?8ɘ�;�d��C´点���Z�%�o%�R��!o+�H��A����ʋ���p���R�u,�)̩�A�,����Z"YI8�F(W���s�׺'�ĉ.�5�5-�R��x�B�����+�)h�&��[�g�2�G���H��̍y�������M��
�c��s�9��0���7�bb���*�B^���o�����	8E�E#���j������h�������;F���V��n,L��  ngKe������.�v�߾L�׬\�������Ni>��ۛ��n��ٌ�m��V!�����#��ro_�c����o�~������k�fֲ=w�`n3d��T�Gz~�'t��๰Y��]+/�?.n�3�3������p���� rW��ߢf%�\\���m9��@Cab
6Gu�:���x:�h�4��w�?�E9Q���r��>>ȞTwp��d 5�%m���I-Jo��;nj��:�>���:���0���ǂ�;]�~�����NTԸr|����9�g}�I<����m��f��I�S�0�D鱡�7et�R�,LMϴ�kC4�"-�w,3�s���-��ߌ��%uu?���.���1qg��f��G���ڹ'�K~�.�P��R�#��Z]L,F#n0v~ë����0�ʬ�3��c�p�,d�6bhhn�a�x��' �����M�8���7g.u���(�MP��YЉ��;\p�4v��g���8����Y��;�[��eC,�����IxjE�=]hs#Z��&j��e�%���&{X�0��ō��� '�=�/*����QhyF�B&o���&��`�v�*-:�Q�6���#(�k�I���F.�S
A������'��.U;����6)m.�R�5�5�&��E=s#[�Rb�E!dn�[Fpr�s���]"�-� K�V��z�]k���RdOW=J�(��劇M����[��������߉���#��F�7J�%n�Kvb������M��eo�K�����Л`���K���Q*m�1���+3���h�Z���9�h�Y�8��6��7���L�D<��A�����K4��!��k/��*V������x�|\�A`��hF�ʝ�y�h�L��S�uv��;X�i�q~�U~��.� �~��f�<��i[%������h��Ő|<��e��vtRN��}3Z���
��/�4�]�$��Wi���N3���`��=|����	�@[:�]:A'@��DI0�w�=�44j�O��=J��gkb!�D�� �D8��o�KHo��Q`#:@yi;��ũ��N'�ï���̏at�\1E�U{�L��®���F�n�ۉP�4��~�+�ѧ%X���=�|��,N�:�%�#��������周{����eq���M���˥�)�N��p*�A	}�m�����c���n�$�Q�}��P�5Ol7����-["p�SLz�}� Ɲ 2f~��T !��Й���bW4��eI�b+q�l���d��06O�C�F�aGp	I��̎�^�OQ����P�#0����׋���JJ۵px&g�E� H[�&�d�}�F��JY�t�W?�����������N�����k:��������Vt!�HIO������%呧��j���Jv	%D�	6c��ZX��s U}�H���x���-�&w��ʸ@�����)o�{�>
�����=�/�@/:�{��������c��@{�V�L&S��� �KB<�z6"�9U86�>CW1�;W/��k���Fڛljs���ܐa�ùdܷ$��:�l8�S����h�����lI�^6���s�R�Bo�������P����^�֮g��Q�~,,���y��(�����OE����[��o��v
@]����w�j���:&[��`�j?y��U����	2@�����{����O�>C����sGח��M�F���&�6F+Ñ���/ihq�Go��υ|Ϥ�	����L�)?����G�*�O�x��Wy�<����'����NQ y�Ǯ͎�����H�o�:{
�(����K����bv[e���K�7�F�j��ۋ�zN?c��۹bZ���$"�G�1�3x
69a���8�fP�!�ʬf}CC8���;Z��ɇ�0l�������gV�g�%�oU�W�����K�\�Es��I5�g�����t���`�Q�IJZ���^" `E �T������h�%��/����	YF�[�Y[��z{�4�r΍��*U��*b��~�:�6��&6�z8�+�4��i�5�j�\��9���(Nrw�BL��U*��t;�9д�x C��Vpm�J�!�D">����(6&���Q-B�C{pOa��(ʩ�vD*��D�ՙ���9m�DSN������'�m9��"��oզ�lM��-2F��)���En\G�Ml��7
G�rI���f�O_�	�$��h��hm��(�T�&M�&�����!4W�2�j%�kS��y �y���9u>���c�����5O �Ղ�(����kv'��ѫ>#?�v �3:��~�ڏ�Y��K7� �{�@��I�E��´����ŖBx]��#��2��ȡ�t��D�a:G��b��Sؔ)e60?g�hZL\�Di##��lUo)��À��#��x�ZkU�9@	�hT�;rm�F�2�<	{���V������"�9��A�<��d�B����r�tP�\�Ovqq$)i�:WS��Z�湈�P^sx�%�!f.r�A6��pN�@����Ϗ�-P]�L����9RB�<�r�� ��E�Wx�&�����Y�(�^P�HZ�Q|��T�#J:�� ����|��'O��;���3k/�H�I��<B�I����#(R�v��bKmq��J��;�CH��q��ѱ8\�t�������O��r���Z����&�@�3�$�(EI��$�n��.��d="�߄�)H��e���P�"��nor�R�h;�� �QA8�Je^0�cR�F�-�i������w׍Q���8r|8�[�{K˥�3���C;:h��ҍKP�'D��t�k2����kJP��fZ�����mm��Z%

8x�=�_���Ы��x�t�+Q�R�ۅ��+��lH&�֝�8L䔽�3ǖ%f���$��儜�
M�^N�0��(�D͠E�V����x�B��&��&�XvF�)<X3����2>�'�r�:�4�H<!/n��d	�}qz
�&����Q]S�	���fO�:5c&�+�.o%ÝYR��ċ���G>Gjj�����$�Ţ���^��-l����V�'^���u�p�*�뉅�L9{3[�wT���wҖ<��
x�ki��K�:mN�߼����<��<�3�#s���k!1a6��<��n���ビ4��lT^3M��Z*���]b�X��C�[B4��f�(ٍ��k�����}�<>C� j(ZB6p �-��߼�m�����p菵�Q
�ϊ=G�=;Ao���^��v��_;K��L��fTb��x����u��8#1:W�s��|A8���ǩi���}e3����٭m� �:'ߥ�I�e}�$~ˇܼc2rIG��]o��Ţ��bO���dRP���Ĝ���uG"�n3�d<�f��X��L��63M�	{k��év@��m����m&��I���%����n<���B�
j�)�<ܲY(�L�౺d�_"�~	����Y��W���lB���&�ĵ��m���&�����\*"P遲^�Q�����s�M�-�,0��2D����P�0�[ޜ������rg{(q�Ľ�J��/%�{\��C�h���w���[�:���Z����Fq&�-9[y�-�=��dW�y�{aA���-�����S8`>*e���^�˟͘���s#�p��65�qE�sʜky�2�9'H}��9%ۺz��mJ�)�6�Fܐ��K�=O���}R]�l�p�أ�wW�W�[���[��J�dl�����?n��U>��7zCh���OJ�1���J���C)t����`��m�O@�6%۔l�l5����`�
6��e�(SE�*#m��C    ���]mo�F�+<}(r�-K�l˹ڈ_{����}+(jm�"�IGI�v/9 i=\Q�Aq�ĉm�/���fvIG��"G�%�q�,�ܝ��gf�����\bj���mOϹK�Wn�e�0��r[�����H%�sѴ�bb:s���n��]���+��MG�mؖ��ɮa���U�r����iBw�e�ԛ[˖{��p�˫v�v��c�H�����u��&j�NE-��S[Q��6aM~��,M��p�D�f��&��Z_M�M�&��]f��[w$X�I�(�J+;��c�X��?){E?2s0`	3���?��9�������r��|�M ��0?�����[�$j\��n�k%�lh�WV��W�j6w%�����~�����j�g�t�t,&�g׳�Ŷ���v8=g{�]���s�p��d�����e��Нz	��u�,�э�����{�������e�tk!-�3A:;3ݝbz>��N137��N��͆ىb6��c�s�t����L�iv:�c�4a=F�N��{Mjja��X��T�����{�6=3��5�����y��yw/���wl3{������Q�����j�|1/K	CX��K���pqpqpqpq#�����HV�y���ȓ���Ë_�W����2%�S��uQߵ��E�~s�=��΅�� RA�ҁ�J	"�AF*=C����\]C���iȬ�������s�u���1=Qga��������1������+��
x5.x�X��b���T8�E����G:x���|��{����Y��@T��vI������P
m��0.6��$-�Zd�\�Ld�0��o1t7�q������ׂ������~��W�-x�ҁ}-�ί�g~U�������o��_��c��R@E�PEb�^��k���HG��	i�}	H}�����`���{j������犂N���~5x.�}���A����W5��S���(�?�7��m����-��Җ��g����+]�["zG���	]�J-'��=-
7��T���C~M��I*�K��!�� F�o����!�9c�.���.�CX�����p�]��p傾�}�k�k�k��q�������ۀm�E���J?O_���uR���/s�?LNj+�+4�\.���yQImrA<]W
8:8�P�����pӱ�9�:���r!4B��^��U�\.ɡ[����p��uGX^l�.%�$ѯڥ��%�q̙\ӝG���m��~�5�+�HW���� ]��>��J�ͭ��7B{j�:�ΜVn��������ߍ7w]�]\Ҷv�B�&^s��琜#XA�Ҟ�J;+�`[_�ۀm�6$bHĮ=Cv����$��W�xT"�J<��2���G��L����H��1�T����l�]M��)c$+K�h���i��ʊn<�q�]+ۈuDX<�/݉J�M�����+��az<��cS���H7�n��>��;/����]ӐY�&7m���Ip�p�p��g�,���G�qӱ��8I�`������X����Lޅ��пw�&#�a�6[���L�l�"�������V���s�+�f,�A�6'�Z�'��cj�ۉ�>������떹-\�wUi��H,�_?�P$*HT�e���j� l���r����Xͩ�!����;�������*����b��[Re�Qf���\_���������}�e�d_��������pw��S��E*~�ޝ��<Tu���bt��M��1nZ���IrdɈY�|D��Y��� fA�21▛��b�m�C�4=�kI!�I�&�$�/�}�pSj�v�@P��6T��j�m}�l����F$r0w$�<�M��;���t���3R��){��{�_=X���C$�(��8ql�C;z�V�Q��`��������T @�~��E0��	Fܴ- ��:^�z(�v��ݘǪ���\D�꿗��j����5�Ї�`/,i������o������Y��G�������/Յ�+�i~=�k��k��>Zs�3�������
!B*�u���.�^ۥمم�P��W��M�b.rM�_�`+���Õ�A��T��GJ������@���C�q3{��V�;�_.�W�RY�`��o�c>�F�<yl�C��� �z �l�������n6f���hAl0�ʝ�<�c�7]�/��2��V�2�2���s�uX�m��	��X�����&��ﶵ��k�dGD�W��Zٵ�E���c��k��nbˣ	�c�u+��?2d2�$�dF
�b���6�qwˣY�~��_JF�ܭ6��y~B�p�p�$p�#�ށm}�l�ې��r�rW���Tum1���%*�Hd:�R�[���W0c򓈥	��nZя ��w�~��t�;��w�@��B�@}�������
+/���wĊ#�GJ��-3��<yЮ�;�??����'�'�'�'�Ѽz ��X�M�t� � d 2 �|����0@ _�m���Z��&?��&�ȶ�*1�����a��������>W�R�\b��?���6���@�/��yMV>��}Y�������`��<�����I��B����*˝����,~~��{�j����L����K�7�q(��x��[���/躿�u�7���-]�HI�#VR�߅ӶG뼐:qd?�������e�v��m��)-d���Z�L��L�쑲k���� 5��/��;��w��&���T�jd���i|�ݯI�������UiBglu��K��@�C���߸�i�7�R��M]mrw��O�Z�ȃؘ�,xF�U揺>���F�?udU�� �P�M�?���o��l����Dj&`Ђ�>#Yx"���|����@P3�l�UqY���|�%�	$5ςDn$�&$j�NU��1@��U��O��'�;�j��}؜D�)!t:x�:��D�&&ܭ��O�vQ��I�v��x8��>�P�y�6#���Z#X��#ToPtj<�Fx����J���ԱN�|F�5�Ð��NQ2b�O'�D�&a��P�(|���T�K��9EN��a��ϯ���!�M��LFg>l4��6"�#�)V�C
H�Ud��/�3��N��r\���|
4Oy�aRz�9�����P�G�y���ߌs��u�ON��O_�fr����;����#"6�!lXz�P����)��d�x�W��OfvlI@�a:.O_������a�^���e�Z�67���m'��#R.鹙�չ&���rd���=I;�
�z� ���]���NɿOA�v�O7H�{E7u���H��0�MZ�n�qiR����)�m�&Q=���!��{Z�n�J�	͑�8w��Q�3� ��}yg�祢�2�RW�>�eg�e���}���e��Q�ϫe���T����(/\з���(�V����T���ή*c$=I���4��3���ܑ���c���n��Q൫�n�,ˏ9;�T~�SvKFK�  �� PK     ! �d��  �     word/footer1.xml��Ks�0���w���v��&��'&��䐆Iȭa˶�QI`��]���f \,�J�ۿ����z�3���0)�;qDE(#&��y���.d,ɤ����ƹ}�r�������sNj��16aJ91'��ZۓPr,㘅�RG��zn9SZ��HuKĊ�ƅ��h�&9�S�-]w�`�_�A���IE,�Rsb��	�D�-U��X�`�@�gF�R�F�Z)E�_I��&B
�pɩ�eF�i�0)S����`1m ��^bųf_���qĸ�J�G~]J�U�?&z�)m�>vs6J8a�K����:\ox��pf�a�a��fû����*O�\��Ǝ�݋��U��X�ײ����<�D�U����"EP{�CePqK�4R�z��b�"��+�N����O/���b%������u˚�,�z���HBѯ%_@SG�~Jk%G2F����E�?K
�K�[Z`2�L�q`�Ja�7����߈��u/���͝Ӹ�4&��n��S=�MF�$�D���G�$���!�#΢[hΨ��7
NuA�^��n3��9]���f:A���&O������ͼ��m��OC��ҝT;gp~:T%Օl!gZʸ�|v�/�=�Ru���h���2��ȣ�   �� PK     ! �xK�  g     word/endnotes.xml̔�n� ��+�,�	v�tS+N��QW�Um�(�1���8y���m��i.{1f~�fu�E�c�r%MC0IU��6A^�'KXGdJ
%Y�̢��շU3�J� !m\i���9cli��S��QVenJ��*�8e�R&ų0
�?me�B�_D�E-����RC*p��9�91��Ft6d�o��#H��4���)#����bA�[�'����W^pw dx�aT�J#�1�x�������q�(Z
&]V�%m�u��4��;��T;Qtv���]�MS�8F~[JQ4�O�pDE<��#�ߘ�A��h�n�80;�Xvb�"�=��iTz{Y�U��/�=ȷ�����������21�9����R�Z�"�} ��
�����M�*vf�ib�S�O4�j;S���S�@q�}���-��HY��G�t^/~�7�G��	�`D2Ǡׄޡ���f�~�Tzݤt
��
�����l�Ơ��)}�U�qY�-��c���角O$=���_   �� PK     ! A4�
       word/footer2.xml��]o� ��'�? ��,�Z�N�-�ԛ)���Ǭ�C������.S�4�n�9p��5��ݞ���0)�� 2eb������c�Hq!M��x���嶎3���&�I`n��2$��9gDK#3;'�#�e�PTK��E͛ҒPc��,*l`�#�i�T��%{��kK�##<�t�7��~�TT��Lj�����X��j�
[��
f\���R��C�+>%n�tM����)kIJN�m���� �ə֔���R}�/�y�
��m�u[�8�~WJ^��?&����xĐ1��{��	�L�Z����� �����!��́�G�V�˪�S�R�4v�A�,U���v��6��yʱrG���a'�Ư�s�j\�@S�O	\��T�:vp��� �	�E�؇�4�eaOG�G���M�d�c�.�3�|�7�#�l�}9��j���{�݄�ָY����85�����XxK��0�!�4��wt�Z�k�`#�?ţw�~Y������   �� PK     ! *�	�  m     word/footnotes.xml̔�o� ��'��xO���K�8ն�Sߪ��(�1���8����5U�4/{1�>�=nu�E�c�p�	��!
���r�MП������$KЁt���eU���`�	C��R4A��*��М	b��S2;� 0d�W�S<���S(3��E����~-դr�8�4'ڲ���.�,�-^����@1�63ЂX7�[,�~+��q����2��0��R˸ELz)�%n��C���m\6@K���#b�
��ɹ��T|��6��;��N�]���ub�Te ��ߖR����(Q��=�H�7f�D.���:��Í�f'��.C,Z61<�Jm���o�h�:ڃ|�Y�a]�jo��6׉yΉrOY��a+A���)r�\����%h}�N�*���SD�%�&hՆ�M]�N��$�ߗ˟ޢ^ڰ���=�y�K��ŏ���`�N�3"�e�لޡ���f�~�Tzᤴ��z�{����l�tcP��>̏��\�u�z~�k�_����siM��/   �� PK     ! �M&:  �     word/theme/theme1.xml�Y݊7�/���;����o��v�f7	�MJ.�yF�fd4����޴�ҋ�����.4��4��gXHhӇ�F��l��t%���;G�Α>i</ a���P�P�^˸��/4q�����)��K��wnq�0ڂ-��|�U,F�h��:F��R@.��+�
�)VJ�Z1�84@�v�����pm8�2�S�="�y78����Qj�������������}Q~*��I[wT��4�	��1�K��7 �-�$�������5�9�������QE�1o�04Mˬ��%��U\�ޫ�j G�<��Z�f�kͱ9PR���ֻղ�������V�O�KPR4W�����0J��&&��m*x	J��|���u/A>��h]�jU;��2��޴�~�2�g�bn�%�!յ�;����L6�8|:FC�;<`�`���p�\��D+M19�y��h��� ϟ<9=~|z�����?�+v�a���^~��ߏ~����/��(���'/~����s�֗'/�<���?x������8@����	j@�z�>�y�v�E0����㾂�:�jp����~0����لc��(�]JI�2휮�c�0	=��l��݀�@7�����d,V:ֹ�}�мNDʡ�B�A�GGi�nc��u;�Ft��m:kC���jʌ.�@�e�#(��f��P�s�E*R�Ht.Q���phÀ�;��:�{S�(��ȴ�=E����*t�!ѧ}�L�8�;��<�KG����3�<��h$�(�)ג����"0\��[)�>{o�2�_ qτ���~��!D�yqI��)���p!�Ͽ~�W���x�n3��/�"��,�6e.~���'�u$6��N��	��^������q���r�^�������CL���I-��tݾh��d�:0�Eq>����e�(�sχc1lY��Es�^�4/!�Y�;� �`��Ik����
ȳ���hgOZk��Uk�^�<����m_�Dn0�DUC��6�AB�l#,����Z�1ϊ؏ ƿgXf�H�?H��)�O���L��:�fz͘�f2���-7�Dn��E���u3K�B/�*�z�M�:�%m �Z�b�U-�Ɓ�1�@Q��_�($^�2>�Q�1�xF~�]���b���@[�R�����k�޾��G>�h8D_ӒUE_�D�{Np\�Az�w��L�(e��q ]�E4]�r�;��\ͷ���X�E!�p~���<���Nn�����|2/NҹOݳ�⎜h�9@�SS�o�ϱ�t_a�H���5S�[wJ��@�Q�S�Ō5ԲV��/��Ks����`y��Dzϔ��OtpG�����N�$Ut$�����D	dk�.GLnwKV۴+�](5�^����B�jWm˪�{V���Tp?([��}�~C��.�}��K�^�/84(R�=�(�凗rE��|o�q�����Z�߬6;�B����n�QhڵN�[���~׶��=H�ٮ�f��(�ʶ]0k��~�Y���J۬�=�}ok1����W���  �� PK     ! ��T�  �     word/settings.xml�W�r�6}�L�A����F��ڸ��(� ��$�I�R��N���[h�ێ�'{v�v���cU��nUozC���3��qk|���]c�v��E�j�5�dk|x���.~+�����[�ʶƩ��i���D{�YxP�L�qS	}n֙����,��#�6&7jk�u�O.�U�iժCכ��p(29}f��uG�Xe�J�ݰ�F�8��=M;{���7 O������CU�zJް݋��7�����2ٶp@U9,�ea�ok����W`N�0z���>�����\lڧJ>Ύ��-!�O�^=&��*�o���b_��
����!��T�Z]�F���!Ʀry��"��N5�� ��C��NB���z׈N!Ru�U9���7�Ep4�hqP��U'���g`P�[cM��&��e��V����?���͕�xG��n��`R�
buu��T��u��C��hP6Xք)o��g�ެK�8�渏]jR�M��y�(�2f�6�9�r�f@�yE(�P���pfZq�"��S�I�#��C<_!��9(k��Z8b�ɔ�/F��C����f[ht,����b��4L�|~��̉Ј��q�E'%h\Nlݩk��(b�$BY�3)7���܄E)�-�n���#�
�xĊ9��㌘�ذ��sxl���%̎	 G�:�,�EmBӦx���i(���<E�E��(�����=�bJy��p;���m;�� ����7 �C_��9�F�-�LC�
l�[XC��2j�/lj�A��:u�u6#�z���R_h�Q
�qU�����������{}���%Tv�ٝ�3�^�@[��L���h�X�qy'�q�6<n��Q)�_�Y�7 R��չы�m�˅:5�ɲ��OE5���~7[�Ё<��u�������wP;e�Ob����>�?C��z��Wy'�f,��#�eq<u����rh�����&��a"�~g�=�e���,�̜e�"�f����Yf���tUeQ�C�0{�A�����タ�AhO���؈AR�Q0uf�����вɼ��/�)�J<��Ф]�'u�t{�Wn�=�`>Օ��/��bV@����4/���Z�N��y����*���>t��es�QH�P
������Y�����I�����W��   �� PK     ! �|��  H�     word/styles.xml�]�r����*��Sr���K�L�(��T�dZ�����`� V$s���)�\rJR���8�咟a�F�v6�):�H\ �a�_=�3�����wސ(�,�ku�[	=6���^�����Nˉ7��>�^�ĭO>���>�x'W>��o�5K�����؛����9	��)�7�?�������-�s7�c���j��n[
&��¦S���[$L��vD|���xF�q�vQ�E�y�<���?�\�`:} P/b1�&�ŨI(n�i˿0�t�0&8���؎�r�r��ӳ�E���H���*G�>�lN���L݅���gt����I�\<tc��S�
P��d?�i��!n����-�9����$����ֶ8c�[���ﵺ�lˁhAa��gٶh���U�%{-n�:��w��F['��p[]X��r�7��]���ӄ�@��ԧB��n���Bx�]$L�D���`���y��h>IE����3杓�I�w����WO�#�".��֮<'�xB��N&$���|>#᫘L��?;���6xl�{���?�^zd.�������0����>�4�2�(&��g����܄��GAt�E���r�ōk�G�NԻ����D��:��N4����Չ$�m���r�
��n�Ѩ��G�%4�F*h��8�@G�h���	SN�<]悽���j��}���.�ws`��9��n��f��ӹ���m��9Y�qӡ���,L�l�X��8	�l��KYv�D�G"+i&�l�#n������"5��Q�9l�L��"�yӆ���y�츓	ǳ�di<b��������@E%脋`l!6��5,N,�/C��V���	�ԁ�E�yӘk-?<�qs_	�����%�vBLb5�$L��@�4�$L�� Ǚ-)4K�Rh���,�-�O[~Sh����,�M�5��)M|���N�����i���8�g�� ͻ5g���{��#f��a�׌=�#6�rN�}�͙P#h[}3�4\4�p͖�Vx���³��^s�=��f1b{b��9Y��2���/�ns��I� [���bk*(���/��V�i#�[ټak�檺���6OAZh�ϼ󊴌�zr5'/��#1�gdb�$�Xky�w%%�$�gnLe�T���5�v�;o|AǾKC;�n.�{#�'�ϟ9�l.�N�;��X��������d�K;��Eqxe�j�-MI�j��I���vҐZ�C%ޯ�՘����qD�{Zb	����Â�x^�����`H��ƍ��'�%�S+`�i�x1~M���s��}�H�|��Jk{p͇	��C�&�D�Z��\�-�ٺ�ߍc�]R5Ƴu����m^�)<�h���90���К�����K<�,�l_�Ő�x��$ޯ":�F��ń�E��Ł�J@�;vr`�o�Ɂ5�w'�4ȁي3�ݿ�U���8�`��L�ي3	f+�z�2��A��.&i+�r��:�0!��Ente	��'g��	��8bS�ӛ�-@�)j��`;��E��dl�i�f�,̈��Ϙ���u�#-���m2�Ov4n±�zd��	�4פ����I������fԚ�|F�f�s2[���a�퍖Y�^0�|�2���[�̞�	]YC���^}c���f��H�`9�i	�9�l�%,G5-�9wjZJ�,���؍�KaT?�O|��(Z���*�V�e!8����T�}����z�������"=
FNz�ں�CT	�%yCEώI��|��)@ޗ��Z��K��N��z�NaL�R�^���B����v��C��;z��	HQ+i�Q)I�R;7�!j')=:[����=.[A{�lQL�U�Q���p@�*�@��HA�*07*DAB��
!�B�0�P�=N���D��D�-T�*�@B��
!�B5�k͍�
Q�B�h�B�P�x��P�=N���D��D�-T�*�@B��
!�B�(�s#�B�P!Z�-���Cs�B{�P���P!��P!
Z�-T�*�@B��
!PB�FB�(h�B�P!Z�r���P�=N���D��D�-T�*�@B��
!�B�(�s#�B�P!Z��*>���6�~�S{�~��+ը��G��P��PY��X��Ex�عS� bO��@�اLNQk��������O�����I=!�Lx��%�S�W�|�y��H�[�Qg�*��-A7دJ�R��M)�;�Ui&g�јWe�9tqU��BWe�!tpU>���oZj�i��� T�ca�G�
K�U���0꒦G�˞�.�z�Z<�z(4�z(3��̰T�U���"Q`̩�P�TC(3�ab�R�T�'g=�� ƜjeL5�2�veX�!�j����a���1�BS�̨��;,�K5D�R��0�TC(c�!�ՠJFS�TC,���j cN5�2�BUQ-gQ
T�Ι�a9C\��3�%眡A���6��r���*�W-�I�#�eO�P�F=�O-�X=�a=�ոj��js���T�%-ոj��j\�TI5�Z�S���ʨ�UKeT�'g=�ոj��j\�TI5�Z�S���ʨ�UKeT㪥2�v�Zs�q�R%ոjIO5�Z*�W-�Q���ʨ�UKZ�q�R%ոj��j\���W-�Q���ʨ�UKeT�%-ոj��j\�TI��Zھ(|�I`��񃓫9���=03I�I��O'{-W~SI4�Q_�R�R�mUk���(��:���9���1�ק���קF�2�_����*�Pסڦ|�~Uk����Z)j��,y��;ތ��S/|�y�ܣy��lΚ��h��z�6=��.��V��D�DUӏbA�hҵkW�cS�x3�~J��i("�B��3m��Rq����G���P�L�to�-濱���Nk���.6&�Y���ʺ���W�[<�zY߮���-遖�_�z��ȟ��"�f~���j�Z/ʺ���u�����~E}�𵗡r6g�B����k�Ҁ��r�d�+\+�d��V_�/��S&��SWY�X�܆L�"��*s0��>�i��믖�?.���~�\�]~�|w���[g�g����r
��(ϡ�)B����t���� �|�v��P# }�w2]=��{"�q��A|�L52�U��l������<����A
���;ͨA�}��鷢�p��������{��w�&*(bx!n�T�{�m7����Ջ7��r�������J\��с���lg���Cr��PP�aX5\Nm��k��S6 ���q�� n?�?T���n��r��F��,�Jʓ�/����c�/����BiY�����S�(�d�NN����A�\��u
���5�Dǜ��0��A�}[�/�6Gn�@-z})�L'��i��y�/�X�:��6���FK�Җՙ��>�-6f��jD���<�;GY'[�L�"�$	�n"�a"�H~S��/<gͤ�
o��� ��ua������Ӊ;�3����81��6g�;���Hw@g��&�uGtGٴ���0{TLwD��"LwĠ�����~gCKG���������p؆��v�ɩ���m�tv����d]����({`C{H8���*Z,�nSυ���po��߯��r�=�忾�������;2=�K�4��r��H��Ȱ��Q��cK���T���ߩݵf��x�\]�h�^�Y�w��,�/ 	\\���-��O��E[�{V�������
Ǫ�_P̰��Us\����_f��(��b���'ְ�G��GG
,�(�ٙ������Ro.�Z�X�3��Vgq��H�ԝ��K��r^ �u#�e#�|�K��K|ܧ7�Y�c������/��j�n�������p�;�r�̖�oe���I��YW��(��vo����/��ʗ��8Ñ��(w�\�_��H�l�-<����|�����1.�t��=�~w�����B_�������S�)cj�VTN��W�Ga9�s1˿�x��ݨ��ר���?�/   �� PK     ! ��H  �u     word/numbering.xml�ˎ�6����/c�oF&�,��iP4St-˜�� ��LWE_����Xy����&Y"%���+g(��!��g�y���u[F����1; ��W��t7��a�F���V��{�n����w��v7�6���� ���.���8&Yk���ص�Џ��xl�.�?>�`v~�bx�c��o�(�v�ۚ�03g=7��
�l����6�<�mp�F$Fc�SC�4? |�臮��'�5�ϛ������;~�&Y97��7�7�L�)���LҮdy���{�&3�ڸ���72!p`|/Z�A�S��|�΍l/�غN^opb�	1KGeo�I���t���-rl�A&�M�p�μ'�i{�������g�?3 G τ��`�w���(���`o�ng���\�B��l���]g>�� ��kM�<?4����A2%�wp95�Q�V�q��~�_���LB ���+���p�3���x���ͷ�Ka*s�2d�w������K �:�eh�~F��,�����Ч��L95}�l�~���ā�FE�����I�>�͹���X�E�r�8 .,>���ї?�)���R<fՃ_B�a{H&*�/瓞�M�)��d�e��a���8B΍,N�O/��w��:��Q��A�+�hB�d�+LұSOp{O�"��,+$%p������=����E2��&�A8�v�9)���x^�ϼ&u�/���7�����;���):��q���It�t�u����׎8�&#��#.��ۋ8Q \»�8�F#Nb	���"N�Ɉ�µ��"N�ш�E�%�}�1Gt��q}Q ��l6��"�O�����5���Kї�/E_��};�8��}�"��/Y�}=�(}��UE�2G���d��&�9V��})�R���;��/Y�Q���Kq}�"��A_4���w�j���~R�UC�J�\8�V��})�R���;��/Y�Q���Kq}�"��A_��c�/��h�NS�����yy�i@��fúh8�+`ٮ���dG�wkط!�r�t�?��E�"[Q�6dIn�Fү�kz劄2E���� JNm ����.�9{���!��7�$lIu���z�t2��;c�F���z�t
��PCh�oҩ��jإ!Q�6�4�Iw���P��3�T��4;�*g���ꦏ0Wui�N(� }W��z��"��76�=�.��ұ�O��zd�k��	�ڞ��X� �J�!.)>#��d�v�����ÓS���h�iMI�U0���s�㑀-S=�nC�إL��㑈�􌳺V�^M�A�x$a�=�0�=^k[��zT;�
M�?!��7M_
������ӝ�u�Y�]�x��1@zعl�5d�G��3�MV�v�1am�aK���YM�/�Qx�����"�.�G��\#'���&O�s"�c��d�*�����ǭ&I�v��f�Q؛��[M6J,��u��l�Q!\����FY$\���d��.��#�}Ѽ�g_Q3X]S���ܜ�U�n-����F�1�D��ׁ�@>���$%��Q���B�|c�؃�f��6ʎ�&#q�&�f�r�~�N^%WY'�]��"�ٱ�fy��Ij�Zn��g�rK���r���j�u�iv�Ԯ�����U�m�5�Xn��h�\�2� �EF�c���S\�I:�Zn�/qB�6�"?�����b�-T]�T���A��h�	꓁:�4A7�����L�Q��o���v۬�N%��{�~9��]�K{��w��v�xE��i�.mɣWt��S�e�+���{wiK���KI���c�+��t�лK[�^ե�&�oBf�L^p-�}(��0�*��Q��^�HK鵏Z9��G�IG�}�kU��o����bC��j���g�'O
������/����04(P�@!�B ����%_�^�.P�	��O�H1Iͳf�]��f�F��Yzw��Yⷊfg�n�,�\�,�QU�,���f齤�N^z]z����x�Yz7��Yr����V�,��TьK	��]��jwa�$�n�v�gJ���  �� PK     ! t?9z�   (   customXml/_rels/item1.xml.rels �(�                                                                                                                                                                                                                                                                 �ϱ��0�����ho��P��K)t;J�GILc�Xji߾�+t�(���Q���E]1��h��jP>N~��j����.�����G{��J	����D60��o���,W�0��H9X)c�t��l'�_u����ݓ���|P�=�;6��w�#w	�E�v
���d*���yB1��ߪ��	�k���  �� PK     ! ����   U   ( customXml/itemProps1.xml �$ (�                                  ���j�0����u��M[�5����`W�qCl�c�>����Nⓐ���;�w�A'`�ʀh��5���r�{ !J����N��Cنc+���FmIj�T�����3��5���P��9=�5�͖�s�Ŷ�|Ij��C�ӑ��meX�]v譌	}ϰ����jY�e;�椷ov�j�����p�K�ٛ�Zn�6콜�O`U����{E�  �� PK     ! `�b�[  n
     word/fontTable.xmlܔ]o�0��'�?D�/� �*5+Ҥi+Ӯ�q��؎|���$-E	+��J[,����~8���d���՜��8\1�j;'�W˛	q��jC3���9������,Ѫ �+�I6'iQ�3��rIa�s�0�h#i��f�Jj~���eN��(�n�yil�5.:I�4�I��j�kx��ZA*rxr+�q+���F3�w�Y�'�P�6~�2��:)x��D�n��j&�����A�2����5.%?G���҆�3t�+9x*�2&���tʙ�ÏG��Y��Ti�>��4�o����%�^��#oL\���� �� �*Ev|R��TՁ\,}���{�:b���=�iR+>�����V�L����M������η��]D�7D!~���D���y�3��H��x2�o���H���>����n,�4�H`ZQ�4�^4��pӅ#���E8|?�a�F	*�����+�?T(1��ڈ)��R���#�P
�~v%E�ߥ@V4Œ� �;�E`{E��A�] "��)��@�o�
tF���FQ���9�6�E/AXa?+���_ψi_um8_�6-.V�e�VH3��/   �� PK     ! ���W�     docProps/core.xml �(�                                                                                                                                                                                                                                                                 |��N�0�����Y;�
J�R[q*[Q�f�a��Ķ쁰Wμ��*!���p��l��2��ϓǷu݀���I&�D���J/f���$�D"�\K^3�O�ˏ
asa�9c������3�D�9�^,��~:$���9��r���)c��#�0�#�l�R�H{�� �
j��i2I�΋�j�nA���Y+\[x׺M��[�Fc�4�&뭡���8�v��j�t7+�,��QaeAwa����/8�"��G�������y�o���w��r�>u:�PZ����[s�����=l�p�bX�p��ApW��i����y]���~���Yo�]��ս�2Iz˨����@Fab�0�m�"��u~Bʔ�Y̎�t:O��l�3���n�~�7��x�i��Y�'o�[�0��W[�  �� PK     ! �WgC�   2   ( customXml/item1.xml �$ (�                                  ���j�0�_��8롌����A��vq%1�R�Ց�����	v����wk��crL<%($˃��������$�㙰bصu_u|���qJU��,�TZ';c0��)�F��H�y���[@�)˭�]�O�,���Qu��
��}>�c����*�qp��^~�X�ρo�lB�3����-���+�~  �� PK     ! ��E?�  �     word/webSettings.xml�Qo�F���;~oM�H/hZ�+:�a�>�c+�1�2,�n��w���Y���0/�%��~���;�={�a����͢^���)�G�zV����o_?��i���tY����Ǫ�x���vg���Mն���([Y7g�����m7g�I3��V��i�����e�]M��u{5YM���<�իʹ]\,���� tܛ�~����r1�^ճw�j��ϟl�e�X���Ŧ����k�z;�l�Y�4�~V˃��t��l�C��l[7�e�4�LE{S�t���j�ŀ<� }c@��a&�71i>����jv��պ�N/��R��Q������y�t�x������b~>	#���E=��j��t�K�x���z�Z]�7{���?W�w�~[o����n�z����2^η�V��u.����������LgU�=��u.>�wm}0����v�ŭ+zعۯ��!�N���a�� Rr5���$��CP!��`p9!�1s�]�!�A*�W�zE>9C
�A\�A��QD"���Ò���U� � �D.� �H�A͟�a�a�$5t�!G���U�0�P0ROYD����.� 䈆$!xd59�GVÐ#�!�GV���o5?]/��ۚ��U<$��~Y���8�ʡ����Ol�$t�'�oQ��c�~�z%ev�S�<S� B^�&o]N���O9��v��9�r�R����&ri��#u�����ɢ{���	��#RmN��H�Ʉ����lòaL�)M�_��䐞=-�xa�$�m
cǤ�����)L�r+*qtWS��d�HN�<��"�n�4x��ɣ�����&�]��>o�S���kA5���)�-nML��ܧ�/�%���B�~��)j��S�VZa����/`:�b�	c���ǒ��H�r�f��/F�b�3 ����Zb A�䝼��=b�X}�lq�&*��-Lތ0D_��K��=�S�����P�n����9�v�FH��	�~^A�_��X� N����t;$�!x��0�$]�W�t�"ω��z�T�<G�������!�toM��{���^"疙�/E��ţ���͘�=�Y �#g"��d���1����&f�@��OA9*��>��1�ߓ 5�1���~��o�&��p���O5���q���p�
?:B����>�ނ妆w��`�y���8&�;�>�v���ŷ�|9� ��~%!'_�|���JG��D!��̷��=1`�Md'_����*VT�o��&tIA|m�A<uIc���1��� i _�` zHLj,���0�@���/�4=R�@��G�Qt�/�ǩ�������\��z��ʮ2���`����"��c57�$�?'��[ASv\d�f�0��d]J�����Š�x�b���#j�f��h]�S�ѭ�H�W`\���э:�;]��A �ġ����8�,b�~��������q=N��b�Y���8�����>?�}V�3[o��j�z]o_n�]Sm��m�\ֻ���p���xS��b}�<�  �� PK     ! ¯���  �   docProps/app.xml �(�                                                                                                                                                                                                                                                                 �SKn�0���cZ�a;͠pPd�6�$k��D)� #�]z��@�nz�#�V趫j!�y���̐]>�:ۃʚ%�Gc����Tf�$�Ż�9�B��X�r�_�bko�� dX%������Z��z*�k��[j�JI�����x<����P��� �+.����V���]qpX��j�E���ԣ�ƚсe��B���t&[�->e����2�|2C��l�^ȈM��I�|B���i%E���Jzl��Nt�`4ax��G�⁏MM�^�0C�G(΋�n��.Z���6RhXax%t F_v��Z�V�>.� ��YP�q��${��-�^x%L$}XotX�=o�4_����6?����)V�wN;����Th���pS�5�?t��NC�:��*;��GՕ��0�l: l��p�
{����v���ܫ��8!q>�ٛt� %�w��@�k�����k�Pc�v��u�?_�OGc���:r�û�   �� PK-      ! �ªp�  1                   [Content_Types].xmlPK-      ! ���   N               �  _rels/.relsPK-      ! �j.v  l               �  word/_rels/document.xml.relsPK-      ! �)�sF0  n�              �
  word/document.xmlPK-      ! �d��  �               $;  word/footer1.xmlPK-      ! �xK�  g               �=  word/endnotes.xmlPK-      ! A4�
                 @  word/footer2.xmlPK-      ! *�	�  m               JB  word/footnotes.xmlPK-      ! �M&:  �               �D  word/theme/theme1.xmlPK-      ! ��T�  �               �J  word/settings.xmlPK-      ! �|��  H�               �O  word/styles.xmlPK-      ! ��H  �u               �_  word/numbering.xmlPK-      ! t?9z�   (               �g  customXml/_rels/item1.xml.relsPK-      ! ����   U               �i  customXml/itemProps1.xmlPK-      ! `�b�[  n
               :k  word/fontTable.xmlPK-      ! ���W�                 �m  docProps/core.xmlPK-      ! �WgC�   2               �p  customXml/item1.xmlPK-      ! ��E?�  �               �q  word/webSettings.xmlPK-      ! ¯���  �               �w  docProps/app.xmlPK      �  {    
```

