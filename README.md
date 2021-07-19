# Khabar Times
Khabar Times is a sample app which shows the Most Popular Articles from NYTimes based on MVVM architectural pattern.

<h1>Screenshots</h1>
<p align="center">
<img src="https://github.com/Sokhib/Khabar_Times/blob/dev/app/src/main/res/drawable/screenshot1.jpg" width="200" title="Most Popular List" alt="Most Popular List">
  <img src="https://github.com/Sokhib/Khabar_Times/blob/dev/app/src/main/res/drawable/screenshot2.jpg" width="200" title="Article Detail" alt="Article Detail">
 
</p>
<h1>Tech stack & Open-source libraries</h1>
<ul>
<li><a href="https://kotlinlang.org/" rel="nofollow">Kotlin</a> based </li>
<li><a href="https://kotlinlang.org/docs/reference/coroutines/coroutines-guide.html">Coroutines + Flow </a></li>
<li> Jetpack Librariies
<ul>
<li>LiveData - observable data holder.</li>
<li>Databinding - for binding UI components in your layouts to data sources in your app.</li>
<li>ViewModel - lifecycle aware class for storing and managing UI-related data.</li>
  <li>Navigation - for navigating users across the app</li>

</ul>
</li>
<li>Architecture
<ul>
<li>MVVM Architecture (Model - View - ViewModel)</li>
<li>Base URL and API KEY is provided via C++ to add extra layer of security and obfuscation </li>
</ul>
</li>
<li><a href="https://dagger.dev/hilt/">Hilt </a> - dependency injection</li>
<li><a href="https://github.com/square/retrofit">Retrofit2 &amp; Gson</a> - constructing the REST API</li>
<li><a href="https://github.com/square/okhttp">OkHttp3</a> - used as logging interceptor </li>
<li><a href="https://github.com/bumptech/glide">Glide</a> - for loading images </li>
<li><a href="https://github.com/JakeWharton/timber">Timber</a> - logging</li>
  <li><a href="https://airbnb.io/lottie/#/">Lottie-AirBnB</a> - for animations</li>
    <li><a href="https://github.com/intuit/sdp">sdp</a> - size unit to scale with screen size</li>
      <li><a href="https://github.com/intuit/ssp">ssp</a> - size unit for texts to scale with screen size</li>
  
</ul>
