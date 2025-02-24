import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ktgk1.R
import com.example.ktgk1.model.Review

@Composable
fun ReviewItem(review: Review) {
    Column(modifier = Modifier.padding(vertical = 8.dp)) {
        // Hiển thị tên người đánh giá
        Text(
            text = review.user,
            style = MaterialTheme.typography.titleMedium
        )
        // Hiển thị rating dưới dạng 5 ngôi sao
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(vertical = 4.dp)
        ) {
            val filledStars = review.rating.toInt()  // Lấy phần nguyên rating
            for (i in 1..5) {
                if (i <= filledStars) {
                    Icon(
                        imageVector = Icons.Filled.Star,
                        contentDescription = "Filled Star",
                        tint = MaterialTheme.colorScheme.primary,
                        modifier = Modifier.size(16.dp)
                    )
                } else {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_star_border),
                        contentDescription = "Empty Star",
                        tint = Color.Gray, // Nếu bạn muốn giữ màu gốc, bạn có thể bỏ tint
                        modifier = Modifier.size(16.dp)
                    )
                }
            }
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = "${review.rating}",
                style = MaterialTheme.typography.bodyMedium
            )
        }
        // Hiển thị bình luận của người đánh giá
        Text(
            text = review.comment,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}
