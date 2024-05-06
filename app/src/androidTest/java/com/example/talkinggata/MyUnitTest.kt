import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import androidx.test.rule.ActivityTestRule
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.example.talkinggata.R
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class LivePetTest {

    // Define a rule to launch the activity under test
    @get:Rule
    val activityRule = ActivityTestRule(LivePet::class.java)

    // This test checks if clicking the feed button increases the fed value by 5
    @Test
    fun testFeedButtonIncreasesFedValue() {
        onView(withId(R.id.feedBtn)).perform(click()) // Click the feed button
        onView(withId(R.id.fedStat)).check(matches(withText("5"))) // Check if fed value is now 5
    }

    // Stub LivePet class that mimics the behavior of the actual activity
    class LivePet : AppCompatActivity() {
        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            setContentView(R.layout.activity_live_pet)

            // Initialize views
            val fedStat = findViewById<TextView>(R.id.fedStat)
            val cleanStat = findViewById<TextView>(R.id.cleanStat)
            val boredStat = findViewById<TextView>(R.id.boredStat)
            val petImage = findViewById<ImageView>(R.id.petImage)

            // Initialize buttons
            val feedBtn = findViewById<Button>(R.id.feedBtn)
            val cleanBtn = findViewById<Button>(R.id.cleanBtn)
            val playBtn = findViewById<Button>(R.id.playBtn)

            // Set starting image
            petImage.setImageResource(R.drawable.homescreen)

            // Action when feed button is clicked
            feedBtn.setOnClickListener {
                petImage.setImageResource(R.drawable.dogeating) // Change image
                val currentFedValue = fedStat.text.toString().toInt() // Get current fed value
                val newFedValue = currentFedValue + 5 // Increase fed value by 5
                fedStat.text = newFedValue.toString() // Update fed value in TextView
                // Restore image after 2 seconds
                petImage.postDelayed({
                    petImage.setImageResource(R.drawable.homescreen)
                }, 2000)
            }

            // Action when clean button is clicked (similar to feed button)
            cleanBtn.setOnClickListener {
                petImage.setImageResource(R.drawable.dogclean)
                val currentCleanValue = cleanStat.text.toString().toInt()
                val newCleanValue = currentCleanValue + 5
                cleanStat.text = newCleanValue.toString()
                petImage.postDelayed({
                    petImage.setImageResource(R.drawable.homescreen)
                }, 2000)
            }

            // Action when play button is clicked (similar to feed button)
            playBtn.setOnClickListener {
                petImage.setImageResource(R.drawable.dogplaying)
                val currentBoredValue = boredStat.text.toString().toInt()
                val newBoredValue = currentBoredValue + 5
                boredStat.text = newBoredValue.toString()
                petImage.postDelayed({
                    petImage.setImageResource(R.drawable.homescreen)
                }, 2000)
            }

            // Runnable to continuously decrease fed value every 25 seconds
            val decreaseFedRunnable = object : Runnable {
                override fun run() {
                    val currentFedValue = fedStat.text.toString().toInt()
                    val newFedValue = currentFedValue - 5
                    fedStat.text = newFedValue.toString()
                    fedStat.postDelayed(this, 25000) // Schedule next execution after 25 seconds
                }
            }
            fedStat.post(decreaseFedRunnable) // Start the continuous decrease of fed value

            // Similar runnables for clean and bored stats
        }
    }
}
