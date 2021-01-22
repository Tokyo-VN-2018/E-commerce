USE ECOMMERCE;
INSERT INTO CATEGORIES ("categoryid", "name", "biggroup")
VALUES ('BAS','Basic Mobile','Phone'),
('CAM','Camera','Other'),
('CON','Console','Other'),
('DES','Desktop','Computer'),
('MON','Monitor','Accessories'),
('HEA','Headphone','Accessories'),
('KEY','Keyboard','Accessories'),
('LAP','Laptop','Computer'),
('TAB','Tablet','Phone'),
('MIC','Microphone','Accessories'),
('MOU','Mouse','Accessories'),
('SMA','Smartphone','Phone'),
('SPE','Speaker','Accessories')

GO

INSERT into products (brand,categoryid,product_name,price,quantity,description)
--tablet
values('Samsung', 'TAB', 'Samsung Galaxy Tab A7(2020)', 340, 100, 'Your new window to the world - With a slim design, a vibrant entertainment system and outstanding performance, the new Galaxy Tab A7 is a stylish new companion for your life. Dive head-first into the things you love, and easily share your favourite moments.'),
('Lenovo','TAB','Lenovo Tab E10 TB-X104L', 129, 100, 'The Lenovo Tab E10 is the choice for parents seeking a vibrant multimedia tablet that the whole family can enjoy. Its large 10" HD screen and enhanced Dolby Atmos® audio is great for movies, pictures, and games. Child-friendly features like blocking inappropriate content put parents in control of what kids see and do, for added peace of mind.'),
('Samsung', 'TAB', 'Samsung Galaxy Tab A8 8" T295 (2019)', 160, 100, 'The tablet that goes where you go - Discover a practical companion in Galaxy Tab A (8.0'', 2019), a tablet that excels at the basics and adds a lot more. With a design that’s easy to carry with one hand, it is slim, compact, and portable, the ideal blend of performance, design and attainability.'),
('Apple', 'TAB', 'iPad Pro 11 inch Wifi 128GB (2020)', 910, 100, 'The world’s most advanced mobile display. - The edge-to-edge Liquid Retina display is not only gorgeous and immersive, but also features incredibly advanced technologies. From True Tone to ProMotion, everything looks stunning and feels responsive on iPad Pro.'),
('Apple', 'TAB', 'iPad Pro 12.9 inch Wifi Cellular 128GB (2020)', 1344, 100, 'The world’s most advanced mobile display. - The edge-to-edge Liquid Retina display is not only gorgeous and immersive, but also features incredibly advanced technologies. From True Tone to ProMotion, everything looks stunning and feels responsive on iPad Pro.'),
('Apple', 'TAB', 'iPad Air 4 Wifi 256GB (2020)', 888, 100, 'The Apple iPad Air (2020) 10.9 inches 256GB WiFi Silver is a slim and light iPad with a powerful A14 Bionic processor. This iPad Air has a larger 10.9-inch screen than its predecessor. The Lightning port has been replaced by USB-C port and the familiar home button has also disappeared. You can now unlock your device with TouchID via the on/off button on the top.'),

/*camera*/
('Canon', 'CAM', 'Canon EOS M50 Kit EF-M15-45mm F3.5-6.3 IS STM', 723, 100, 'Modern, hassle free shooting for superb results. Compact, sleek and intuitive shooting experience. Clever connectivity and control with Wi-Fi & Bluetooth. Inspiring technologies for stories you will be proud of. Digital Camera EOS M50 body, Camera Cover R-F-4, EF-M15-45 S f/3.5-6.3 IS STM, Lens Cap E-49, Lens Dust Cap EB, Strap EM-200DB, Battery Charger LC-E12E'),
('Canon', 'CAM', 'Canon EOS 800D Kit EF-S18-55mm F4-5.6 IS STM', 672,100, 'AF experience beyond expectation - Experience the fast focusing speed of EOS 800D, which also features an intuitive, easy-to-use UI that guides you to shoot aesthetically-appealing images. The DIGIC 7 image processor and 24.2-megapixel APS-C sensor combine to produce images more accurate and detailed than ever, great for preserving memories of holidays, special occasions and time spent with loved ones.'),
('Nikon', 'CAM', 'Nikon D3500 Kit AF-P DX Nikkor 18-55mm F3.5-5.6G VR', 415, 100, 'A DSLR that is as easy to use as a point and shoot camera. Compact, comfortable design that''s great for travel and special events. Image sensor that''s 15x larger than those used in typical smartphones for sharper, clearer pictures. Works with Nikon’s snap bridge app for sharing photos with a compatible smartphone or tablet. 1080p full hd videos with monaural sound at the touch of a button. Bluetooth version 4.1'),
/*console*/
('Sony', 'CON', 'PS4 1TB Slim Bundled', 27.99, 100, 'Play the greatest games and PS4 exclusive, take your adventures online with PS plus and Stream or download TV shows and movies from Netflix, PS store or wherever you get your favourite entertainment. Hdr-enabled PS4 games burst into life with incredible colour and clarity on an HDR TV, delivering a more vibrant, realistic spectrum of colours. Store your games, apps, screenshots and videos with 1TB model – slimmer and lighter than the original PS4 model and available in jet Black'),
('Microsoft', 'CON', 'Xbox Series S', 34.99, 100, 'Introducing the Xbox series S, the smallest, sleekest Xbox console ever. Experience the speed and performance of a next-gen all-digital console at an accessible price point. Go all-digital and enjoy disc-free, next-gen gaming with the smallest Xbox console ever made. Experience next-gen speed and performance with the Xbox velocity architecture, powered by a custom SSD and integrated software. Play thousands of digital games from four generations of Xbox with backward compatibility, including optimized titles at launch.'),
('Crispy Deals', 'CON', 'Crispy Deals 2 Player Tv Game Set', 16, 100, 'Games are inbuilt, or a Free Cassete is available in package, if not there means, the free games are inbuilt in console. Images are Real Photo Shoot of Products, and Designs Are Newly Applied in a Subsequent time. Two players Playable Tv video game set. Suitable for Kids, and School students. Enjoy the Stage Level, Sports,Shooting, Arcaud, and Racing Games. For these Games you need to buy 8 bit game cartridges individually. and The Package contains only O)ne Default Game Cartridge. '),
/*desktop*/
('Lenovo', 'DES', 'Lenovo Ideacentre 510S Desktop, Warm Silver', 336, 100, 'Processor: 9th Generation Inter Core i3-9100 Processor, 3.6 GHz base speed, up to 4.2 GHz maximum speed, 4 Cores, 6MB Cache. Memory and Storage: 4GB DDR4 RAM, expandable to 16GB with integrated UHD graphics | Storage: 1TB HDD. Operating System: Pre-Loaded Windows 10 Home with Lifetime Validity | In The Box: Desktop, Keyboard, Mouse, User Manual. Ports: 4 USB 3.1, 4 USB 2.0, Headphone/Mic combo jack (3.5mm), Microphone (3.5mm), Ethernet (RJ-45), DP, HDMI, VGA, Serial port, Audio port | Without CD Drive. Warranty: 1 Year On-site Warranty'),
('REO', 'DES', 'REO Desktop Intel Core i5 650 3.2 Ghz/4 GB DDR3 Ram', 261, 100, 'Slim, Elegant, Best in class high speed Desktop for Home, Office use. Intel Core i5 650 3.2Ghz, Reo Intel H55 Motherboard, Reo 4 GB DDR3 RAM. Superfast 120GB SSD Hard Disk with additional 500GB SATA (7200 RPM) Hard Disk (Total 2 Hard Disk inside the System). Intel HD Graphics, VGA, HDMI Supports, 500 Watt SMPS, Wi-Fi Ready. Integrated extra cooling fan for better heat management, 6 USB ports, front USB, front Audio')

INSERT INTO PRODUCTS (CATEGORYID,PRODUCT_NAME,BRAND,DESCRIPTION,QUANTITY,PRICE)
VALUES
--monitor (sua nhe)
('MON','LG 27GL83A-B','LG','27 Inch Ultragear QHD IPS 1ms NVIDIA G-SYNC Compatible Gaming Monitor, Black',20,379.99),
('MON','Acer SB220Q bi','ACER','21.5 Inches Full HD (1920 x 1080) IPS Ultra-Thin Zero Frame Monitor (HDMI & VGA Port), Black',20,93.99),
('MON','Sceptre 35 Inch Curved UltraWide 21','Sceptre','9 LED Creative Monitor QHD 3440x1440 Frameless AMD Freesync HDMI DisplayPort Up to 100Hz, Machine Black 2020',20,379.97),
--keyboard
('KEY','Azio Retro Classic Bluetooth','Azio','Luxury Vintage Backlit Mechanical Keyboard, MK-RETRO-L-03B-US',20,219.99),
('KEY','Kinesis Advantage2 Ergonomic','KINESIS','Ergonomic',20,323.90),
('KEY','Majestouch Convertible 2 TKL','FILCO','Ergonomic',20,179.00),
--laptop
('LAP','Apple MacBook Pro','Apple','16-inch, 16GB RAM, 512GB Storage',20,2249.00),	
('LAP','ASUS F512DA-EB51 VivoBook','ASUS','15 Thin And Light Laptop, 15.6” Full HD, AMD Quad Core R5-3500U CPU, 8GB DDR4 RAM, 256GB PCIe SSD, AMD Radeon Vega 8 Graphics, Windows 10 Home,Slate Gray',20,589.00),
('LAP','Acer Predator Helios 300 PH315-53-71VG','Acer','Intel i7-10750H, NVIDIA GeForce RTX 2070 Max-Q 8GB, 15.6" FHD 240Hz 3ms IPS, 16GB Dual-Channel DDR4, 512GB NVMe SSD, 1TB HDD, WiFi 6, RGB KB',20,1999.00),
('LAP','Acer Predator Triton 500 PT515-52-73L3','Acer','Intel i7-10750H, NVIDIA GeForce RTX 2070 SUPER, 15.6" FHD NVIDIA G-SYNC Display, 300Hz, 16GB Dual-Channel DDR4, 512GB NVMe SSD, RGB Backlit KB',20,1659.99),
('LAP','Acer Predator Triton 500 Thin & Light','Acer',' Intel Core i7-9750H, GeForce RTX 2060 with 6GB, 15.6" Full HD 144Hz 3ms IPS Display, 16GB DDR4, 512GB PCIe NVMe SSD, RGB Keyboard',20,1628.99),
('LAP','ZenBook 15','ASUS','15.6” UHD 4K NanoEdge Display, Intel Core i7-10510U, GeForce GTX 1650, 16GB, 512GB PCIe SSD, ScreenPad 2.0, Amazon Alexa Compatible, Windows 10, Icicle Silver',20,1148.59),
('LAP','Apple MacBook Pro','Apple','16-inch, 16GB RAM, 512GB Storage',20,2249.00)
--smartphone
--mouse
--speaker
--headphone
--microphone
('MIC','Microphone Saramonic WM4C-M1','Saramonic',
--basicphone
('BAS','Nokia 215 4G','Nokia','SUPERFAST 4G. DURABILITY & LONG-LASTING BATTERY LIFE. ENTERTAINMENT. ERGONOMIC DESIGN',20,40),
('BAS','Nokia 5310','Nokia','The return of a classic. Music in its blood. Stay connected 24/7',20,46.5)